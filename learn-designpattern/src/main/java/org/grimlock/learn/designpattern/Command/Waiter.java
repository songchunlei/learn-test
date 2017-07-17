package org.grimlock.learn.designpattern.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songchunlei on 2017/7/17.
 */
public class Waiter {
    private List<Command> commands = new ArrayList<Command>();

    public void setOrder(Command command){
        commands.add(command);
    }


    public void sail(){
        for (Command command:commands){
            command.sail();
        }
    }

    public void removeOrder(Command command){
        commands.remove(command);
    }
}
