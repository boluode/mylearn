package com.boluo.mylearn.timer;

import java.util.Timer;

/**
 * mylearn com.boluo.mylearn.timer
 *
 * @Author boluo
 * @Date 2017/9/9 10:30
 * @since JDK 1.8
 */
public class JavaTimer {

    public static void start() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimer(), 5000, 1000);
        try {
            Thread.sleep(1000000000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
