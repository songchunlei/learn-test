package org.grimlock.learn.designpattern.factory.factorymethod;

/**
 * Created by songchunlei on 2017/7/10.
 */
public class BananaFactory implements FruitFactory {
    public Fruit getFruit() {
        return new Banana();
    }
}
