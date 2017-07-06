package org.grimlock.learn.designpattern.factory.simplefactory;

/**
 * 简单工厂模式
 * Created by songchunlei on 2017/7/6.
 */
public class MainClass {
    public static void main(String[] args) {
        //常规实例化
        /*Fruit apple = new FruitFactory().getApple();
        Fruit banana = new FruitFactory().getBanana();
        apple.get();
        banana.get();*/

        try {
            Fruit apple = FruitFactory.getFruit("Apple");
            Fruit banana = FruitFactory.getFruit("Banana");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        //


    }
}
