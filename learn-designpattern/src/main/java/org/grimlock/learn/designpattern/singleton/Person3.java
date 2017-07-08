package org.grimlock.learn.designpattern.singleton;

/**
 * 懒汉式单例模式
 * 多线程:加入同步方法
 * Created by songchunlei on 2017/7/8.
 */
public class Person3
{
    private String name;
    private static Person3 person;

    private Person3(){

    }

    private Person3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //私有构造函数，提供一个全局的静态方法
    //保证线程安全
    //缺点：其实线程第一次去校验的时候才需要去判断是否为nul，接下去都是走perso，这样就影响到效率
    //因为，第二，第三线程都会在这里等第一线程判断，那么初始化完成以后就不应该去等（堵塞）
    public static synchronized Person3 getPerson()
    {
        if(person == null)
        {
            person = new Person3();
        }
        return person;
    }
}
