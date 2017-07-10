package org.grimlock.learn.designpattern.visitor;

/**
 * Created by songchunlei on 2017/7/10.
 */
public class Park implements ParkElement{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private ParkA parkA;
    private ParkB parkB;

    public void accept(Visitor visitor) {
        visitor.visit(this);
        parkA.accept(visitor);
        parkB.accept(visitor);
    }

    public Park() {
        this.parkA = new ParkA();
        this.parkB = new ParkB();
    }
}
