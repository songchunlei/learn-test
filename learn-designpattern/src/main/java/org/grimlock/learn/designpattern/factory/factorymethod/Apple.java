package org.grimlock.learn.designpattern.factory.factorymethod;

/**
 * 具体产品-苹果
 * Created by songchunlei on 2017/7/6.
 */
public class Apple implements Fruit {
    public void get(){
        System.out.println("采集苹果");
    }
}
