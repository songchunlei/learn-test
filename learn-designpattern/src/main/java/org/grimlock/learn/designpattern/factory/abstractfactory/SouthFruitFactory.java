package org.grimlock.learn.designpattern.factory.abstractfactory;

/**
 * 实现南方工厂
 * Created by songchunlei on 2017/7/6.
 */
public class SouthFruitFactory implements FruitFactory {

    public Fruit getApple() {
        return new SouthApple();
    }

    public Fruit getBanana() {
        return new SouthBanana();
    }
}
