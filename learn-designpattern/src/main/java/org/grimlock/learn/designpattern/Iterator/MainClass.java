package org.grimlock.learn.designpattern.Iterator;

import org.grimlock.learn.designpattern.Iterator.org.BookList2;

import java.util.Iterator;
import java.util.List;

/**
 * Created by songchunlei on 2017/7/8.
 */
public class MainClass {
    public static void main(String[] args) {
        BookList bookList = new BookList();

        Book book1 = new Book("010203","JAVA编程思想","90");
        Book book2 = new Book("010205","JAVA设计思想","80");

        bookList.addBook(book1);
        bookList.addBook(book2);

        Iterator iter = bookList.iterator();
        while (iter.hasNext()){
            Book book = (Book)iter.next();
            book.display();
        }

     }

}
