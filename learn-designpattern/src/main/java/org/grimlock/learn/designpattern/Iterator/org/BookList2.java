package org.grimlock.learn.designpattern.Iterator.org;

import org.grimlock.learn.designpattern.Iterator.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * 不使用迭代模式
 * 缺点：保存遍历状态，很容易混乱
 * Created by songchunlei on 2017/7/8.
 */
public class BookList2 {
    private List<Book> bookList;
    private int index;

    public BookList2(){
        bookList = new ArrayList<Book>();
    }

    //新增
    public void addBook(Book book){
        bookList.add(book);
    }

    //删除
    public void deleteBook(Book book){
        int bookIndex = bookList.indexOf(book);
        bookList.remove(bookIndex);
    }

    public List<Book> getBookList(){
        return bookList;
    }


}
