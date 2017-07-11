package org.grimlock.learn.designpattern.observer.publisher;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by songchunlei on 2017/7/11.
 */
public class MyObServer implements Observer {
    public void update(Observable o, Object arg) {
        Article art = (Article)arg;
        System.out.println("博主发表了新文章:"+art.getArticleTitle()+"_"+art.getArticleContent());
    }
}
