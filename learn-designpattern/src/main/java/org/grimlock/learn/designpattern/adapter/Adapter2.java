package org.grimlock.learn.designpattern.adapter;

/**
 * Created by songchunlei on 2017/7/25.
 */
public class Adapter2 {
    private Current current;

    public Adapter2(Current current){
        this.current = current;
    }

    public void use18V(){
        System.out.println("使用适配器");
    }
}
