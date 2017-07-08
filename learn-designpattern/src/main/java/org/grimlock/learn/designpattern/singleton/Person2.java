package org.grimlock.learn.designpattern.singleton;

/**
 * 懒汉式单例模式（多线程不行）
 * Created by songchunlei on 2017/7/8.
 */
public class Person2
{
    private String name;
    private static Person2 person;

    private Person2(){

    }

    private Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //私有构造函数，提供一个全局的静态方法
    public static Person2 getPerson()
    {
        if(person == null)
        {
            person = new Person2();
        }
        return person;
    }
}
