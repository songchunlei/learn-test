package org.grimlock.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * 非分布式锁
 * Created by songchunlei on 2017/7/11.
 */
public class OrderServiceImpl implements Runnable{
    private static int NUM = 100;
    private  static  OrderNumGenerator org = new OrderNumGenerator();
    //private Logger logger = LoggerFac

    //发令枪
    private static CountDownLatch cd1 = new CountDownLatch(NUM);

    private static Lock lock = new ReentrantLock();

    public void createOrder(){
        lock.lock();
        try {
            String orderNum = org.getOrderNum();//被竞争资源
            System.out.println(Thread.currentThread().getName()+"==================>"+orderNum);
        }catch (Exception e)
        {

        }
        finally {
            lock.unlock();
        }

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
            new Thread(new OrderServiceImpl()).start();
            cd1.countDown();//开始会议，会议开始1个减1个
        }

    }
}
