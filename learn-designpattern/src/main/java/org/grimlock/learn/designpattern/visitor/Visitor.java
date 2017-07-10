package org.grimlock.learn.designpattern.visitor;

/**
 * Created by songchunlei on 2017/7/10.
 */
public interface Visitor {
    public void visit(Park park);
    public void visit(ParkA parkA);
    public void visit(ParkB parkB);
}
