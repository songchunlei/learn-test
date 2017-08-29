package org.grimlock.learn.designpattern.facade;



/**
 * Created by songchunlei on 2017/8/29.
 */
public class Facade {
    private SystemA systemA;
    private SystemB systemB;
    private SystemC systemC;

    public Facade(){
        systemA = new SystemA();
        systemB = new SystemB();
        systemC = new SystemC();

    }

    public void doSomething(){
        this.systemA.doSomething();
        this.systemB.doSomething();
        this.systemC.doSomething();
    }

}
