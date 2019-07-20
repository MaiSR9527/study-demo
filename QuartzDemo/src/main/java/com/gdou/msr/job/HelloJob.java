package com.gdou.msr.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;

/**
 * 业务逻辑，需要定时执行的任务工作
 * 
 * @author maishuren
 * @date 2019/6/22 10:26
 */
public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 编写具体的业务逻辑
        // System.out.println("job执行时间：" + sf.format(date) + " 执行了hello job!");
        System.out.println("job开始时间：" + sf.format(date));
        Trigger currentTrigger = jobExecutionContext.getTrigger();
        System.out.println("trigger开始时间" + sf.format(currentTrigger.getStartTime()));
        System.out.println("trigger结束时间" + sf.format(currentTrigger.getEndTime()));
        JobKey jobKey = currentTrigger.getJobKey();
        System.out.println("当前job的" + jobKey.getName() + "  " + jobKey.getGroup());
    }
}
