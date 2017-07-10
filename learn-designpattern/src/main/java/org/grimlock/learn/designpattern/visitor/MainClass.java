package org.grimlock.learn.designpattern.visitor;

/**
 * 访问者设计模式
 * Created by songchunlei on 2017/7/10.
 */
public class MainClass {
    public static void main(String[] args) {
        Park park = new Park();
        VisitorA visitorA = new VisitorA();
        park.accept(visitorA);

        VisitorB visitorB = new VisitorB ();
        park.accept(visitorB);

        VisitorManager visitorManager = new VisitorManager ();
        park.accept(visitorManager);

    }
}
