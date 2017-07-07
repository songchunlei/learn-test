package org.grimlock.learn.designpattern.proxy.dyproxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Created by songchunlei on 2017/7/7.
 */
public class MainClass {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        MyHandler myHandler = new MyHandler();
        myHandler.setRealSubject(realSubject);
        //反射
        Subject proxySubject = (Subject) Proxy.newProxyInstance(RealSubject.class.getClassLoader(),realSubject.getClass().getInterfaces(),myHandler);
        proxySubject.sailBook();
    }
}
