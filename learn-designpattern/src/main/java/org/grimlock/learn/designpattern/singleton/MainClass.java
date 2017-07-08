package org.grimlock.learn.designpattern.singleton;

/**
 * 单例设计模式
 * Created by songchunlei on 2017/7/8.
 */
public class MainClass {
    public static void main(String[] args) {
        Person per = Person.getPerson();
        Person per2 = Person.getPerson();
        per.setName("zhangsan");
        per2.setName("lisi");

        System.out.println(per.getName());
        System.out.println(per2.getName());
    }
}
