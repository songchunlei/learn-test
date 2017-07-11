package org.grimlock.learn.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import java.util.Date;

/**
 * Created by songchunlei on 2017/7/10.
 */
public class HelloVelocity {
    public static void main(String[] args) {
        //初始化引擎
        VelocityEngine ve = new VelocityEngine();
        ve.init();
        //取得模版
        Template t = ve.getTemplate("hello.vm");
        //取得模版上下文
        VelocityContext context = new VelocityContext();
        //数据填入上下文
        context.put("name","zhangsan");
        context.put("date",(new Date()).toString());

    }
}
