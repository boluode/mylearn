package com.boluo.mylearn.spring;

/**
 * mylearn com.boluo.mylearn.spring
 *
 * @Author boluo
 * @Date 2017/9/11 22:45
 * @since JDK 1.8
 */
public class StaticProxy implements Book {

    private Book book;

    public StaticProxy(Book book) {
        this.book = book;
    }

    public void insertBook() {
        System.out.println("before add!");
        book.insertBook();
        System.out.println("after add!");
    }

    public void updateBook() {
        System.out.println("before update!");
        book.updateBook();
        System.out.println("after update!");
    }
}
