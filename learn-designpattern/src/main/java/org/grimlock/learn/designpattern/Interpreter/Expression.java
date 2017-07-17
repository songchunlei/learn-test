package org.grimlock.learn.designpattern.Interpreter;

/**
 * 抽象解释器
 * Created by songchunlei on 2017/7/17.
 */
public abstract class Expression {
    public abstract void interpret(Context context);
}

