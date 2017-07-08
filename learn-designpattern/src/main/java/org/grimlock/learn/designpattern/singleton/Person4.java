package org.grimlock.learn.designpattern.singleton;

/**
 * 双重检查单例模式
 * Created by songchunlei on 2017/7/8.
 */
public class Person4
{
    private String name;
    private static Person4 person;

    private Person4(){

    }

    private Person4(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //私有构造函数，提供一个全局的静态方法
    //保证非空校验的线程判断安全
    //
    public static Person4 getPerson()
    {
        //第一次检查
        if(person == null)
        {
            //如果第一个和第二个同时进来的，那第一个第二个都为空了
            synchronized (Person4.class)
            {
                if(person == null)
                {
                    person = new Person4();
                }
            }
        }
        return person;
    }
}
