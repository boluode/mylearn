package com.boluo.mylearn.timer;

import java.util.TimerTask;

/**
 * mylearn com.boluo.mylearn.timer
 *
 * @Author boluo
 * @Date 2017/9/9 10:27
 * @since JDK 1.8
 */
public class MyTimer extends TimerTask {
    public int i = 0;
    public String name = "菠萝";
    public MyTimer(){}

    public MyTimer(String name, int i){
        this.name = name;
        this.i = i;
    }
    public void run() {

        System.out.println("***************************--" + i++);
    }
}
