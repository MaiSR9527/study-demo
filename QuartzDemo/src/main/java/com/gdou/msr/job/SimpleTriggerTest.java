package com.gdou.msr.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author maishuren
 * @date 2019/6/22 14:14
 */
public class SimpleTriggerTest implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 编写具体的业务逻辑
        System.out.println("执行时间：" + sf.format(date) + " 执行了hello SimpleTrigger!");
    }
}
