package org.grimlock.learn.designpattern.visitor;

/**
 * 清洁工B，负责公园b的卫生
 * Created by songchunlei on 2017/7/10.
 */
public class VisitorB implements Visitor {
    public void visit(Park park) {

    }

    public void visit(ParkA parkA) {

    }

    public void visit(ParkB parkB) {
        System.out.println("清洁工B：完成公园"+parkB.getName()+"的清洁");
    }
}
