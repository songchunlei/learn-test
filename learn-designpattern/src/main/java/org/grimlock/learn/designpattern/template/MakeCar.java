package org.grimlock.learn.designpattern.template;

/**
 * Created by songchunlei on 2017/7/19.
 */
public abstract class MakeCar {
    //组装车头
    public abstract void makeHead();
    //车身
    public abstract void makeBody();
    //组装车尾
    public abstract void makeTail();

    public void make(){
        this.makeHead();
        this.makeBody();
        this.makeTail();
    }
}
