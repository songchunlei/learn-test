package org.grimlock.learn.designpattern.observer.publisher;

/**
 * Created by songchunlei on 2017/7/11.
 */
public class Article {
    private String articleTitle;
    private String articleContent;

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }
}
