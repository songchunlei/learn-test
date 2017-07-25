package org.grimlock.learn.designpattern.adapter;

/**
 * Created by songchunlei on 2017/7/25.
 */
public class Adapter extends Current{
    public void use18V(){
        System.out.println("使用适配器");
        this.user220v();
    }

}
