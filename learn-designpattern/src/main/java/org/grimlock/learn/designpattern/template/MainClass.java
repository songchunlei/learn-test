package org.grimlock.learn.designpattern.template;

/**
 * 模版设计模式
 * Created by songchunlei on 2017/7/19.
 */
public class MainClass {
    public static void main(String[] args) {
        MakeCar bus = new MakeBus();
        /*bus.makeHead();
        bus.makeBody();
        bus.makeTail();*/
        bus.make();


        MakeCar jeep = new MakeJeep();
        /*jeep.makeHead();
        jeep.makeBody();
        jeep.makeTail();*/
        jeep.make();
    }
}
