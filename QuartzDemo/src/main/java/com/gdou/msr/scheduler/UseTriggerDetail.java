package com.gdou.msr.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import com.gdou.msr.job.HelloJob;

/**
 * 关于Trigger的一些简单使用
 * 
 * @author maishuren
 * @date 2019/6/22 13:36
 */
public class UseTriggerDetail {

    public static void main(String[] args) throws SchedulerException {

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间:" + df.format(date));
        // 当前时间3秒后
        date.setTime(date.getTime() + 3000);
        // 当前时间6秒后
        Date endDate = new Date();
        endDate.setTime(endDate.getTime() + 6000);
        JobDetail jobDetail =
            JobBuilder.newJob(HelloJob.class).withIdentity("myJob", "group").withIdentity("myJob").build();
        // 创建一个Trigger实例，设置开始时间和结束时间
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger").startAt(date).endAt(endDate)
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();

        // 创建scheduler实例
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }

}
