package org.grimlock.learn.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by songchunlei on 2017/7/11.
 */
public class MyObserver implements Observer {
    public void update(Observable o, Object arg) {
        System.out.println("对象发生变化");
    }
}
