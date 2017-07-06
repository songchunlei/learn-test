package org.grimlock.learn.designpattern.factory.abstractfactory;

/**
 * Created by songchunlei on 2017/7/6.
 */
public interface FruitFactory {
    //public Fruit getFruit();
    //抽象化苹果工厂
    public Fruit getApple();
    //抽象化香蕉工厂
    public Fruit getBanana();


}
