package com.boluo.mylearn;

import com.boluo.mylearn.timer.JavaTimer;
import com.boluo.mylearn.timer.SpringTimer;
import org.junit.Test;

/**
 * mylearn com.boluo.mylearn
 *
 * @Author boluo
 * @Date 2017/9/9 10:31
 * @since JDK 1.8
 */
public class TestTimer {

    @Test
    public void testJavaTimer() {
        JavaTimer.start();
    }
    @Test
    public void testSpringTimer() {
        SpringTimer.start();
    }
}
