package org.grimlock.learn.designpattern.Interpreter;

/**
 * 上下文环境类，用来保存语法
 * Created by songchunlei on 2017/7/17.
 */
public class Context {
    private String input;
    private  int ouput;

    public Context(String input) {
        this.input = input;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public int getOuput() {
        return ouput;
    }

    public void setOuput(int ouput) {
        this.ouput = ouput;
    }
}
