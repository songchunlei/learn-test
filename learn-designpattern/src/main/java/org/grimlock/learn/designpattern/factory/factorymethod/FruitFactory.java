package org.grimlock.learn.designpattern.factory.factorymethod;

import org.grimlock.learn.designpattern.visitor.Park;

/**
 * 创建一个类去实例其他的类
 * 工厂（creator)创建实例的内部逻辑
 * Created by songchunlei on 2017/7/10.
 */
public interface FruitFactory {
    public Fruit getFruit();
}
