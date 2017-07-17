package org.grimlock.learn.designpattern.Command;

/**
 * Created by songchunlei on 2017/7/17.
 */
public class AppleCommand extends Command {
    public AppleCommand(Peddler peddler) {
        super(peddler);
    }

    public void sail() {
        this.getPeddler().sailApple();
    }
}
