package org.grimlock.learn.designpattern.command;

/**
 * Created by songchunlei on 2017/7/17.
 */
public abstract class Command {
    private Peddler peddler;

    public Command(Peddler peddler) {
        this.peddler = peddler;
    }

    public Peddler getPeddler() {
        return peddler;
    }

    public void setPeddler(Peddler peddler) {
        this.peddler = peddler;
    }

    public abstract void sail();
}
