package org.grimlock.learn.designpattern.Command;

/**
 * Created by songchunlei on 2017/7/17.
 */
public class BananaCommand extends Command {
    public BananaCommand(Peddler peddler) {
        super(peddler);
    }

    public void sail() {
        this.getPeddler().sailBanana();
    }

}
