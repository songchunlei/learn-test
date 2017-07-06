package org.grimlock.learn.designpattern.factory.abstractfactory;

/**
 * Created by songchunlei on 2017/7/6.
 */
public class GreenHouseFruitFactory implements FruitFactory {

    public Fruit getApple() {
        return new GreenHouseApple();
    }

    public Fruit getBanana() {
        return new GreenHouseBanana();
    }
}
