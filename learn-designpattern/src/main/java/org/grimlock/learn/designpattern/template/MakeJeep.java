package org.grimlock.learn.designpattern.template;

/**
 * Created by songchunlei on 2017/7/19.
 */
public class MakeJeep extends MakeCar {
    public void makeHead() {
        System.out.println("jeep=====>车身");
    }

    public void makeBody() {
        System.out.println("jeep=====>车头");
    }

    public void makeTail() {
        System.out.println("jeep=====>车尾");
    }
}
