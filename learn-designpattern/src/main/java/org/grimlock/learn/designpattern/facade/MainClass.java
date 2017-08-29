package org.grimlock.learn.designpattern.facade;

/**
 * 外观设计模式
 * Created by songchunlei on 2017/8/29.
 */
public class MainClass {
    public static void main(String[] args) {
    /*SystemA systemA = new SystemA();
    systemA.doSomething();

    SystemB systemB = new SystemB();
    systemB.doSomething();

    SystemC systemC = new SystemC();
    systemC.doSomething();*/


    Facade facade = new Facade();
    facade.doSomething();

    }
}
