package org.grimlock.learn.designpattern.proxy.dyproxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by songchunlei on 2017/7/7.
 */
public class MyHandler implements InvocationHandler {

    private RealSubject realSubject;

    public void setRealSubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    //在代码实例上调用处理方法，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;
        onsale();
        result = method.invoke(realSubject,args);
        promotion();
        return result;
    }

    public void onsale(){
        System.out.println("打折");
    }

    public void promotion(){
        System.out.println("代金券");
    }

}
