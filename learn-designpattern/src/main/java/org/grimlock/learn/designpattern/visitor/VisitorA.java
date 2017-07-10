package org.grimlock.learn.designpattern.visitor;

/**
 * 清洁工A,负责ParkA的卫生情况
 * Created by songchunlei on 2017/7/10.
 */
public class VisitorA implements Visitor {
    public void visit(Park park) {

    }

    public void visit(ParkA parkA) {
        System.out.println("清洁工A：完成公园"+parkA.getName()+"的清洁情况");
    }

    public void visit(ParkB parkB) {

    }
}
