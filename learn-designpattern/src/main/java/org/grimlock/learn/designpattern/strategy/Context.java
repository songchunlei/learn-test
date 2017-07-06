package org.grimlock.learn.designpattern.strategy;

/**
 * 策略的外部封装类
 * Created by songchunlei on 2017/7/6.
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void encrypt(){
        this.strategy.encrypt();
    }
}
