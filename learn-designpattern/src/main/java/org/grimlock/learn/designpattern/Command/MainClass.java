package org.grimlock.learn.designpattern.Command;

/**
 * 命令设计模式
 * Created by songchunlei on 2017/7/17.
 */
public class MainClass {
    public static void main(String[] args) {
        Peddler peddler = new Peddler();
//        peddler.sailApple();
//        peddler.sailBanana();
        Command appleCommand = new AppleCommand(peddler);
        Command bananaCommand = new BananaCommand(peddler);
        /*appleCommand.sail();
        bananaCommand.sail();*/
        Waiter waiter = new Waiter();
        /*waiter.setCommand(appleCommand);
        waiter.sail();
        waiter.setCommand(bananaCommand);
        waiter.sail();*/
        //
        waiter.setOrder(appleCommand);
        waiter.setOrder(bananaCommand);
        //移除命令
        waiter.removeOrder(appleCommand);
        waiter.sail();

    }
}
