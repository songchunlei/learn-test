package org.grimlock.learn.designpattern.Interpreter;

/**
 * Created by songchunlei on 2017/7/17.
 */
public class MinuesExpression extends Expression {
    public void interpret(Context context) {
        System.out.println("自动递减");
        //获得上下文环境
        String input = context.getInput();
        //进行类型转换
        int intInput = Integer.parseInt(input);
        //进行递增
        intInput--;
        //对上下文环境重新赋值
        context.setInput(String.valueOf(intInput));
        context.setOuput(intInput);
    }
}
