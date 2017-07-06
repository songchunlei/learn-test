package org.grimlock.learn.designpattern.factory.abstractfactory;

/**
 * 抽象工厂
 * Created by songchunlei on 2017/7/6.
 */
public class MainClass {
    public static void main(String[] args) {
        FruitFactory ff = new NorthFruitFactory();
        Fruit apple = ff.getApple();
        Fruit banana = ff.getBanana();
        apple.get();
        banana.get();

        FruitFactory ff2 = new NorthFruitFactory();
        Fruit apple2 = ff2.getApple();
        Fruit banana2 = ff2.getBanana();
        apple2.get();
        banana2.get();


        FruitFactory ff3 = new GreenHouseFruitFactory();
        Fruit apple3 = ff3.getApple();
        Fruit banana3 = ff3.getBanana();
        apple3.get();
        banana3.get();

        //缺点：如果增加一个产品(比如梨子)，代码就需要都来一遍：



    }
}
