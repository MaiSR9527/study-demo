package com.gdou.msr.scheduler;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import com.gdou.msr.job.CronTriggerTest;

/**
 * {@link UseCronTrigger} 基于日历的作业调度器 一些简单实用 比SimpleTrigger更好用是基于Cron表达式
 * 
 * @author maishuren
 * @date 2019/6/22 14:26
 */
public class UseCronTrigger {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("开始时间:" + df.format(date));

        JobDetail jobDetail =
            JobBuilder.newJob(CronTriggerTest.class).withIdentity("myJob", "group").withIdentity("myJob").build();

        // 格式[秒] [分] [小时] [日] [月] [星期] [年]
        // 秒0-59 分0-59 时0-23 r日0-31 月1-12或者JAN-DEC 星期1-7或者SUN-SAT 年可空或1970-2099 还有一些通配符如：, * ? /
        // 每天10点15分触发: 0 15 10 ? * *
        // 每天的14点到14点59分(整点开始,每个五分钟触发): 0 0/5 14 * * ?
        // 每天周一到周五每天上午10点15分触发: 0 15 10 * * MON-FRI
        // 每月第三周星期五触发:0 0 0 ? * 6#3 6:星期五<---3:第3周
        // 2016年到2017年每月最后一周的星期五的10点15分触发: 0 15 10 ? * 6L 2016-2017
        // 每个月第三个周五的10点15分触发: 0 15 10 ? * 6#3
        // 每个月最后一天的10点15分触发一次: 0 15 10 L * ?
        // 每月周一到周五的10点15分触发一次: 0 15 10 ? * W
        CronTrigger trigger = (CronTrigger)TriggerBuilder.newTrigger().withIdentity("myTrigger")
            .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();

        // 创建scheduler实例
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        Date date1 = scheduler.scheduleJob(jobDetail, trigger);
        System.out.println(df.format(date));
        // 4秒后挂起，可以重新执行。shutDown()是直接关掉scheduler
        Thread.sleep(4000);
        scheduler.standby();
        Thread.sleep(3000);

    }
}
