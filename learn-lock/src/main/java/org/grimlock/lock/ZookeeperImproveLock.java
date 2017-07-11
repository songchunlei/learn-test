package org.grimlock.lock;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * 分布式锁-提升
 * Created by songchunlei on 2017/7/11.
 */
public class ZookeeperImproveLock implements Lock {

    private static final String LOCK_PATH="/LOCK";
    private static final String ZOOKEEPER_IP_PORT = "localhost:2181";
    private ZkClient client = new ZkClient(ZOOKEEPER_IP_PORT,1000,1000,new SerializableSerializer());
    private static Logger logger = LoggerFactory.getLogger(ZookeeperImproveLock.class);

    private CountDownLatch cdl;

    private String beforePath;//当前请求节点前一节点
    private String currentPath;//当前请求节点

    //判断有没有LOCK目录，没有则创建
    public ZookeeperImproveLock(){
        if(!this.client.exists(LOCK_PATH)){
            this.client.createPersistent(LOCK_PATH);
        }
    }

    @Override
    public void lock() {
        if(!tryLock()){
            waitForLock();
            lock();
        }
        else
        {
            logger.info(Thread.currentThread().getName()+"=====>获得分布式锁");
        }
    }

    private void waitForLock() {
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {

            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                logger.info(Thread.currentThread().getName()+"抓获节点删除事件");
                if(cdl!=null){
                    cdl.countDown();
                }
            }
        };
        //之前节点增加数据删除的wather
        this.client.subscribeDataChanges(beforePath,listener);

        if(this.client.exists(beforePath)){
            cdl=new CountDownLatch(1);
            try{
                cdl.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.client.unsubscribeDataChanges(beforePath,listener);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        //如果currentPath为空，第一次加锁就赋值currentPath
        if(currentPath == null || currentPath.length()<=0)
        {
            currentPath = this.client.createEphemeralSequential(LOCK_PATH+"/","lock");
            logger.info("==============>"+currentPath);
        }
        //获取所有临时节点并排序，临时节点名称为自增长字符串
        List<String> childrens = this.client.getChildren(LOCK_PATH);
        Collections.sort(childrens);
        //如果当前节点排名第一
        if(currentPath.equals(LOCK_PATH+"/"+childrens.get(0))){
            return true;
        }
        else
        {
            int wz = Collections.binarySearch(childrens,currentPath.substring(6));
            beforePath  =LOCK_PATH+"/"+childrens.get(wz-1);
        }
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        client.delete(currentPath);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
