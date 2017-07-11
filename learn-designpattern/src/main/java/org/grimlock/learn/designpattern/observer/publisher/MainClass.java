package org.grimlock.learn.designpattern.observer.publisher;

/**
 * 订阅模型
 * Created by songchunlei on 2017/7/11.
 */
public class MainClass {
    public static void main(String[] args) {
        BlogUser user = new BlogUser();
        user.addObserver(new MyObServer());
        user.publishBlog("青年文章","少年往事");
    }
}
