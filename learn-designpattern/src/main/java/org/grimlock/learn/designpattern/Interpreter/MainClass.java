package org.grimlock.learn.designpattern.Interpreter;

import java.util.ArrayList;
import java.util.List;

/**
 * 解释器设计模式
 * Created by songchunlei on 2017/7/12.
 */
public class MainClass {
    public static void main(String[] args) {
        String number = "20";
        Context context = new Context(number);

//        Expression expression = new PlusExpression();
//        expression.interpret(context);
//        System.out.println(context.getOuput());
//        Expression expression1 = new MinuesExpression();
//        expression1.interpret(context);
//        System.out.println(context.getOuput());
        List<Expression> list = new ArrayList<Expression>();
        list.add(new PlusExpression());
        list.add(new PlusExpression());
        list.add(new MinuesExpression());
        for (Expression expr:list
             ) {
            expr.interpret(context);
            System.out.println(context.getOuput());
            
        }


    }
}
