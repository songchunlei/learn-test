package org.grimlock.learn.designpattern.factory.factorymethod;

/**
 * Created by songchunlei on 2017/7/10.
 */
public class AppleFactory implements FruitFactory {
    public Fruit getFruit() {
        return new Apple();
    }
}
