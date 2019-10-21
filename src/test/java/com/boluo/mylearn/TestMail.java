package com.boluo.mylearn;

import com.boluo.mylearn.mail.JavaMail;
import org.junit.Test;

/**
 * mylearn com.boluo.mylearn
 *
 * @Author boluo
 * @Date 2017/9/9 18:38
 * @since JDK 1.8
 */
public class TestMail {

    @Test
    public void testJavaMail() throws Exception {
        String myEmailAccount = "***@qq.com";
        String myEmailPassword = "*****";
        String receiveMailAccount = "****@qq.com";
        JavaMail javaMail = new JavaMail();
        javaMail.send(myEmailAccount, myEmailPassword, receiveMailAccount);
    }
}
