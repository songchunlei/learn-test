package org.grimlock.learn.designpattern.visitor;

/**
 * 公园管理者
 * Created by songchunlei on 2017/7/10.
 */
public class VisitorManager implements Visitor {
    public void visit(Park park) {
        System.out.println("管理员：负责公园"+park.getName()+"检查");
    }

    public void visit(ParkA parkA) {
        System.out.println("管理员：负责公园"+parkA.getName()+"检查");
    }

    public void visit(ParkB parkB) {
        System.out.println("管理员：负责公园"+parkB.getName()+"检查");
    }
}
