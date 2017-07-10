package org.grimlock.learn.designpattern.factory.factorymethod;

/**
 * 工厂方法模式
 * Created by songchunlei on 2017/7/6.
 */
public class MainClass {
    public static void main(String[] args) {
        //获得苹果工厂
        FruitFactory ff = new AppleFactory();
        Fruit apple = ff.getFruit();
        apple.get();
    }
}
