package org.grimlock.learn.designpattern.template;

/**
 * Created by songchunlei on 2017/7/19.
 */
public class MakeBus extends MakeCar{
    public void makeHead() {
        System.out.println("bus=====>车身");
    }

    public void makeBody() {
        System.out.println("bus=====>车头");
    }

    public void makeTail() {
        System.out.println("bus=====>车尾");
    }
}
