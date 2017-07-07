package org.grimlock.learn.designpattern.proxy.dyproxy;

/**
 * 真实服务
 * Created by songchunlei on 2017/7/7.
 */
public class RealSubject implements Subject {
    public void sailBook() {
        System.out.println("卖出");

    }
}
