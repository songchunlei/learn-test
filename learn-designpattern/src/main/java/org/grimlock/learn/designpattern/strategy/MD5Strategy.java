package org.grimlock.learn.designpattern.strategy;

/**
 * 具体实现
 * Created by songchunlei on 2017/7/6.
 */
public class MD5Strategy implements Strategy{
    public void encrypt() {
        System.out.println("执行MD5加密");
    }
}
