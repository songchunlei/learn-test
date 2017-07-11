package org.grimlock.learn.designpattern.observer;

import java.util.Observable;

/**
 * Created by songchunlei on 2017/7/11.
 */
public class Person extends Observable{
    private String name;
    private String sex;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("是否改变"+this.hasChanged());
        this.setChanged();
        this.notifyObservers();//通知
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
        this.setChanged();
        this.notifyObservers();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.setChanged();
        this.notifyObservers();
        this.age = age;
    }
}
