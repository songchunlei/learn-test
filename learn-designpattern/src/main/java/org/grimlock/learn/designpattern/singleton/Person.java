package org.grimlock.learn.designpattern.singleton;

/**
 * 饿汉式单例模式
 * Created by songchunlei on 2017/7/8.
 */
public class Person
{
    public static final Person per = new Person();

    private String name;

    private Person(){

    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //私有构造函数，提供一个全局的静态方法
    public static Person getPerson()
    {
        return per;
    }
}
