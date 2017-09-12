package org.grimlock.learn.designpattern.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songchunlei on 2017/9/12.
 */
public class Person implements Cloneable{
    private String name;
    private int age;
    private String sex;
    private List<String> friends;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person clone(){
        try {
            return (Person)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Person deepClone(){
        try {
            Person person2 =  (Person)super.clone();
            List<String> friendsTemp = new ArrayList<String>();
            for (String temp:this.getFriends()
                    ) {
                friendsTemp.add(temp);
            }
            person2.setFriends(friendsTemp);
            return person2;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<String> getFriends() {
        return friends;
    }

    public void setFriends(List<String> friends) {
        this.friends = friends;
    }
}
