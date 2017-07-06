package org.grimlock.learn.designpattern.memento;

/**
 * Created by songchunlei on 2017/7/6.
 */
public class CareTaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
