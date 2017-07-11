package org.grimlock.lock;

import org.apache.log4j.spi.LoggerFactory;
import org.apache.zookeeper.ZooKeeper;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 分布式锁(基于zookeeper)
 * Created by songchunlei on 2017/7/11.
 */
public class OrderServiceImpl2 implements Runnable{
    private static int NUM = 100;
    private  static  OrderNumGenerator org = new OrderNumGenerator();

    //发令枪
    private static CountDownLatch cd1 = new CountDownLatch(NUM);

    private Lock lock = new ZookeeperLock();

    public void createOrder(){
        lock.lock();
        String orderNum = org.getOrderNum();//被竞争资源
        lock.unlock();
        System.out.println(Thread.currentThread().getName()+"==================>"+orderNum);
    }



    public void run() {
        try {
            cd1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        createOrder();
    }

    public static void main(String[] args) {
        //这样就出现了线程不安全
        for (int i = 0; i < NUM; i++) {
            new Thread(new OrderServiceImpl2()).start();
            cd1.countDown();//开始会议，会议开始1个减1个
        }

    }
}
