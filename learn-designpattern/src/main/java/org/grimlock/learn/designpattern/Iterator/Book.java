package org.grimlock.learn.designpattern.Iterator;

/**
 * Created by songchunlei on 2017/7/8.
 */
public class Book {
    private String ISBN;
    private String name;
    private String price;

    public Book(String ISBN, String name, String price) {
        this.ISBN = ISBN;
        this.name = name;
        this.price = price;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void display(){
        System.out.println("shu:"+name);
    }
}
