package org.grimlock.learn.designpattern.Iterator.org;

import org.grimlock.learn.designpattern.Iterator.Book;

import java.util.List;

/**
 * Created by songchunlei on 2017/7/8.
 */
public class MainClass {
    public static void main(String[] args) {
        //BookList bookList = new BookList();
        BookList2 bookList2 = new BookList2();
        Book book1 = new Book("010203","JAVA编程思想","90");
        Book book2 = new Book("010205","JAVA设计思想","80");
        /*
        bookList.addBook(book1);
        bookList.addBook(book2);
        bookList.addBook(book1);
        bookList.addBook(book2);
        while (bookList.hasNext()){
        Book book = bookList.getNext();
        book.display();
        }
        */
        bookList2.addBook(book1);
        bookList2.addBook(book2);
        List<Book> bookDataList = bookList2.getBookList();
        for (int i = 0; i < bookDataList.size(); i++) {
            Book book = bookDataList.get(i);
            book.display();
        }
     }

}
