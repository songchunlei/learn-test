package org.grimlock.learn.designpattern.observer;

/**
 * 观察者设计模式
 * Created by songchunlei on 2017/7/11.
 */
public class MainClass  {
    public static void main(String[] args) {
        Person person = new Person();
        //注册观察者
        person.addObserver(new MyObserver());
        person.setName("lisan");

    }
}
