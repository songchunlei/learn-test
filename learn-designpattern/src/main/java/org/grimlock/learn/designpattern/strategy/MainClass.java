package org.grimlock.learn.designpattern.strategy;

import com.sun.tools.classfile.ConstantPool;

/**
 * 策略设计模式
 * Created by songchunlei on 2017/7/6.
 */
public class MainClass {
    public static void main(String[] args) {

        /*传统模式
        Strategy strategy = new MD5Strategy();
        strategy.encrypt();
        */


        Context context = new Context(new MD5Strategy());
        context.encrypt();


    }
}
