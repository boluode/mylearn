package com.boluo.mylearn;

import com.boluo.mylearn.spring.*;
import org.junit.Test;

/**
 * mylearn com.boluo.mylearn
 *
 * @Author boluo
 * @Date 2017/9/12 7:55
 * @since JDK 1.8
 */
public class TestSpring {

    @Test
    public void testStaticProxy() {
        JavaBook javaBook = new JavaBook();
        StaticProxy staticProxy = new StaticProxy(javaBook);
        staticProxy.insertBook();
        staticProxy.updateBook();
    }

    @Test
    public void testDynamicProxy() {
        DynamicProxy dynamicProxy = new DynamicProxy();
        Book book = (Book) dynamicProxy.bind(new JavaBook());
        book.insertBook();
    }

    @Test
    public void testCglibProxy() {
        CglibProxy cglibProxy = new CglibProxy();
        EnglishBook englishBook = (EnglishBook) cglibProxy.getInstance(new EnglishBook());
        englishBook.addBook();
    }
}
