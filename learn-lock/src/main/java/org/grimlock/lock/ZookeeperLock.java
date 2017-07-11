package org.grimlock.lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.exception.ZkNodeExistsException;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.apache.log4j.spi.LoggerFactory;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.logging.Logger;

/**
 * zookeeper锁，因为zookeeper节点是唯一的
 * 但是这个锁存在问题：
 * 1。接收很多无关事件，羊群效应。一个事件解锁了，向其他等待的发送结果，性能很差
 * 2。存在死锁可能。因为节点是持久化的。比如停电了，没有执行lock.unlock().那节点永远死锁了
 * Created by songchunlei on 2017/7/11.
 */
public class ZookeeperLock implements Lock {

    private static final String LOCK_NODE="/zk-lock";

    private static final String ZK_IP_PORT="localhost:2181";

    private CountDownLatch cdl ;

    //端口，超时，序列化
    private ZkClient client = new ZkClient(ZK_IP_PORT,1000,1000,new SerializableSerializer());

    /**
     * 加锁，堵塞锁
     */
    @Override
    public void lock() {
        if (tryLock()){
            System.out.println(Thread.currentThread().getName()+"===========>获取锁成功");
        }
        else {
            waitForLock();//等待获取锁
            lock();
        }
    }

    private void waitForLock() {
        //创建监听器，监听节点删除事件
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
                //节点改变执行操作

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                //节点被删除执行操作，激活这段唤醒发令枪，让cdl.await方法跑
                System.out.println("===============删除锁事件");
                if(cdl!=null){
                    cdl.countDown();//唤醒
                }

            }
        };
        //基于zookeeper的watch
        client.subscribeDataChanges(LOCK_NODE, listener);

        if(client.exists(LOCK_NODE))
        {
            //判断节点在不在，线程就要等,用发令枪等待
            cdl = new CountDownLatch(1);//等一次
            //为什么不用sleep，因为要唤醒
            try {
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //关闭监听
        client.unsubscribeDataChanges(LOCK_NODE,listener);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        //尝试获取lock,在zookeeper下创建节点，如果成功，证明已经有锁了
        try {
            client.createPersistent(LOCK_NODE);//创建持久节点
            return true;
        }catch (ZkNodeExistsException e)
        {
            return false;//节点存在，就是已经有锁了
        }
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        client.delete(LOCK_NODE);//删除节点，就是释放锁
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
