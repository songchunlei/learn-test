package org.grimlock.learn.designpattern.factory.simplefactory;

/**
 * 创建一个类去实例其他的类
 * 工厂（creator)创建实例的内部逻辑
 * Created by songchunlei on 2017/7/6.
 */
public class FruitFactory {
    /**
     * 获得Apple实例
     * @return
     */
    public Fruit getApple()
    {
        return new Apple();
    }

    /**
     * 获得Banana实例
     * @return
     */
    public Fruit getBanana()
    {
        return new Banana();
    }

    public static Fruit getFruit(String type) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
       /* if(type.equalsIgnoreCase("apple")) {
            return Apple.class.newInstance();
        }else if(type.equalsIgnoreCase("banana"))
        {
            return Banana.class.newInstance();
        }
        else
        {
            System.out.println("类型不存在");
            return null;
        }*/
            Class fruit = Class.forName(type);
            return (Fruit) fruit.newInstance();
    }
}
