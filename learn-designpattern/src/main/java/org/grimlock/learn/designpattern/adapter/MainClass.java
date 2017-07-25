package org.grimlock.learn.designpattern.adapter;

/**
 * Created by songchunlei on 2017/7/25.
 */
public class MainClass {
    public static void main(String[] args) {
        /*Current current = new Current();
        current.user220v();*/

        Adapter adapter = new Adapter();
        adapter.use18V();

        Adapter2 adapter2 = new Adapter2(new Current());
        adapter2.use18V();
    }
}
