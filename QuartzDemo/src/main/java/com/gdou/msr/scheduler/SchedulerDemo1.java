package com.gdou.msr.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import com.gdou.msr.job.UseJobExcutionContext;

/**
 * {@link org.quartz.JobExecutionContext}的使用
 * 
 * @author maishuren
 * @date 2019/6/22 12:35
 */
public class SchedulerDemo1 {
    public static void main(String[] args) throws SchedulerException {
        // 创建一个JobDetail实例，并与HelloJob绑定
        JobDetail jobDetail = JobBuilder.newJob(UseJobExcutionContext.class).withIdentity("myJob", "group")
            .usingJobData("msg", "hello usingJobData").usingJobData("intNum", 1).usingJobData("Float", 1.2F).build();
        // 创建一个Trigger实例，定义该Job立即执行，并且每个两秒钟重复执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("myTrigger", "group1")
            .usingJobData("msg", "usingTriggerData").startNow()
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(1)).build();

        // 创建scheduler实例
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String d = sf.format(date);
        System.out.println("执行时间:" + d);
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
