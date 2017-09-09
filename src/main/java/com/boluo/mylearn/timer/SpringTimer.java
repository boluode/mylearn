package com.boluo.mylearn.timer;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.springframework.scheduling.timer.ScheduledTimerTask;
import org.springframework.scheduling.timer.TimerFactoryBean;

import java.util.List;


/**
 * mylearn com.boluo.mylearn.timer
 *
 * @Author boluo
 * @Date 2017/9/9 10:39
 * @since JDK 1.8
 */
public class SpringTimer {

    public static void start() {
        MyTimer myTimer1 = new MyTimer("刘义", 100);
        ScheduledTimerTask scheduledTimerTask1 = new ScheduledTimerTask();
        scheduledTimerTask1.setTimerTask(myTimer1);
        scheduledTimerTask1.setDelay(5000);
        scheduledTimerTask1.setPeriod(1000);

        MyTimer myTimer = new MyTimer();
        ScheduledTimerTask scheduledTimerTask = new ScheduledTimerTask();
        scheduledTimerTask.setTimerTask(myTimer);
        scheduledTimerTask.setDelay(5000);
        scheduledTimerTask.setPeriod(1000);

        List<ScheduledTimerTask> scheduledTimerTaskList = Lists.newArrayList(scheduledTimerTask1, scheduledTimerTask);

        TimerFactoryBean timerFactoryBean = new TimerFactoryBean();
        timerFactoryBean.setScheduledTimerTasks(Iterables.toArray(scheduledTimerTaskList, ScheduledTimerTask.class));
        timerFactoryBean.afterPropertiesSet();
        try {
            Thread.sleep(1000000000000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
