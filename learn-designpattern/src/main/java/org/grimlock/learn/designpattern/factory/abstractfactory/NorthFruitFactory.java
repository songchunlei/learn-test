package org.grimlock.learn.designpattern.factory.abstractfactory;

/**
 * 实现北方工厂
 * Created by songchunlei on 2017/7/6.
 */
public class NorthFruitFactory implements FruitFactory {

    public Fruit getApple() {
        return new NorthApple();
    }

    public Fruit getBanana() {
        return new NorthBanana();
    }
}
