package org.grimlock.learn.designpattern.proxy;


/**
 * Created by songchunlei on 2017/7/7.
 */
public class ProxySubject implements Subject{
    private RealSubject realSubject;

    public void setRealSubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public void sailBook() {
        onsale();
        if(realSubject == null)
        {
            realSubject = new RealSubject();
        }
        this.realSubject.sailBook();
        promotion();
    }

    public void onsale(){
        System.out.println("打折");
    }

    public void promotion(){
        System.out.println("赠送代金券");
    }
}
