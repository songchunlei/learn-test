package org.grimlock.learn.designpattern.Iterator.org;

import org.grimlock.learn.designpattern.Iterator.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * 不使用迭代模式
 * 缺点：容器类方法，功能太多
 * Created by songchunlei on 2017/7/8.
 */
public class BookList {
    private List<Book> bookList;
    private int index;

    public BookList(){
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

    //判断是否有下一本书
    public boolean hasNext(){
        if(index>=bookList.size()){
            return false;
        }
        return true;
    }

    //获得下一本书
    public Book getNext(){
        return bookList.get(index++);
    }

}
