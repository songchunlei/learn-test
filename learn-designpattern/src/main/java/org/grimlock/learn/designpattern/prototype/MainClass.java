package org.grimlock.learn.designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * 原型设计模式
 * Created by songchunlei on 2017/9/12.
 */
public class MainClass {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Song");
        person.setAge(30);
        person.setSex("男");

        List<String> friends = new ArrayList<String>();
        friends.add("张三");
        friends.add("李四");
        person.setFriends(friends);
        Person person1 = person.clone();

        System.out.println("person===============");
        System.out.println(person.getFriends());
        System.out.println("person1-clone===============");
        System.out.println(person1.getFriends());

        friends.add("赵武");

        /*
            这里新增的赵武也被克隆出来了，因为在内存里，只是克隆了一个指向
            这是浅克隆
         */
        System.out.println("person===============");
        System.out.println(person.getFriends());
        System.out.println("person1-clone===============");
        System.out.println(person1.getFriends());

        /*
            深克隆
         */
        Person person2 = person.deepClone();
        System.out.println("person===============");
        System.out.println(person.getFriends());
        System.out.println("person2-clone===============");
        System.out.println(person2.getFriends());

        friends.add("王流");

        System.out.println("person===============");
        System.out.println(person.getFriends());
        System.out.println("person2-clone===============");
        System.out.println(person2.getFriends());

    }
}
