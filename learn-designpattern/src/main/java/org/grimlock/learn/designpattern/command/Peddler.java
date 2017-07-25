package org.grimlock.learn.designpattern.command;

/**
 * Receiver 被调用方
 * Created by songchunlei on 2017/7/17.
 */
public class Peddler {
    public void sailApple(){
        System.out.println("卖苹果");
    }
    public void sailBanana(){
        System.out.println("卖香蕉");
    }
}
