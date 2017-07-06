package org.grimlock.learn.designpattern.memento;

/**
 * 备忘录设计模式
 * Created by songchunlei on 2017/7/6.
 */
public class MainClass {
    public static void main(String[] args) {
        Person per = new Person("zhangsan","man",30);
        per.display();

//        //原始备份
//        Person backup = new Person();
//        backup.setName(per.getName());
//        backup.setSex(per.getSex());
//        backup.setAge(per.getAge());
//
//        //修改
//        per.setAge(20);
//        per.display();
//
//        //回滚
//        per.setName(backup.getName());
//        per.setSex(backup.getSex());
//        per.setAge(backup.getAge());
//        per.display();

        /*备份模式
        Memento memento = per.createMemento();

        per.setAge(50);
        per.display();

        //回滚
        per.setMemento(memento);
        per.display();
        */

        CareTaker careTaker = new CareTaker();
        careTaker.setMemento(per.createMemento());

        per.setAge(50);
        per.display();

        per.setMemento(careTaker.getMemento());



    }
}
