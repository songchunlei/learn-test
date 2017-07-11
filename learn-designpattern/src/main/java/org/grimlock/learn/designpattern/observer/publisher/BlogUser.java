package org.grimlock.learn.designpattern.observer.publisher;

import java.util.Observable;

/**
 * Created by songchunlei on 2017/7/11.
 */
public class BlogUser extends Observable {

    public void publishBlog(String title,String content){
        Article art =  new Article();
        art.setArticleTitle(title);
        art.setArticleContent(content);
        System.out.println("发表文摘："+title+"内容："+content);
        this.setChanged();
        this.notifyObservers(art);
    }

}
