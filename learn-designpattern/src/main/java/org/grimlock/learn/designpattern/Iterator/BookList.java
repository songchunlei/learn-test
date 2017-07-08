package org.grimlock.learn.designpattern.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 迭代模式
 * Created by songchunlei on 2017/7/8.
 */
public class BookList {
    private List<Book> bookList;
    private int index;
    private Iterator iterator;

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

    //可以实现多个迭代方法
    public Iterator iterator(){
        return new Itr();
    }

    private class Itr implements Iterator{
        public boolean hasNext() {
            if(index>=bookList.size()){
                return false;
            }
            return true;
        }

        public Book next() {
            return bookList.get(index++);
        }

        public void remove() {

        }
    }

}
