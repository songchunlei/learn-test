package org.grimlock.learn.designpattern.visitor;

/**
 * 公园a部分
 * Created by songchunlei on 2017/7/10.
 */
public class ParkA implements ParkElement {
    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
