package org.grimlock.learn.designpattern.visitor;

/**
 * Created by songchunlei on 2017/7/10.
 */
public interface ParkElement {
    //用于接纳来访者
    public void accept(Visitor visitor);
}
