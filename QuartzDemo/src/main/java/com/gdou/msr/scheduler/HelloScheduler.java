package com.gdou.msr.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import com.gdou.msr.job.HelloJob;

/**
 * 调度器入门
 * 
 * @author maishuren
 * @date 2019/6/22 10:30
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {
        // 创建一个JobDetail实例，并与HelloJob绑定
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("myjob", "group").build();
        // 创建一个Trigger实例，定义该Job立即执行，并且每个两秒钟重复执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1").startNow()
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();

        // 创建scheduler实例
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.start();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("执行时间:" + sf.format(date));
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
