package com.gdou.msr.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import com.gdou.msr.job.SimpleTriggerTest;

/**
 * 关于Simple的一些简单用法
 * 
 * @author maishuren
 * @date 2019/6/22 14:11
 */
public class UseSimpleTrigger {
    public static void main(String[] args) throws SchedulerException {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间:" + df.format(date));

        JobDetail jobDetail =
            JobBuilder.newJob(SimpleTriggerTest.class).withIdentity("myJob", "group").withIdentity("myJob").build();

        date.setTime(date.getTime() + 4000L);
        // 距离当前时间4秒后执行，且仅执行一次
        SimpleTrigger trigger =
            (SimpleTrigger)TriggerBuilder.newTrigger().withIdentity("myTrigger").startAt(date).build();
        // 4秒后执行，之后间隔2秒执行一次，一共执行4（首次执行和之后规定执行3次）次
        SimpleTrigger trigger2 = (SimpleTrigger)TriggerBuilder.newTrigger().withIdentity("myTrigger").startAt(date)
            .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(3)).build();

        // 创建scheduler实例
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger2);
    }
}
