package com.gdou.msr.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.*;

/**
 * @author maishuren
 * @date 2019/6/22 12:47
 */
public class UseJobExcutionContext implements Job {

    /**
     * 第二种方法使用getter和setter方法 先定义属性并且与传入的key值一样 并且不需要使用getJobDetail()和getMergedJobDataMap()
     */
    private String msg;
    private Integer intNum;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getIntNum() {
        return intNum;
    }

    public void setIntNum(Integer intNum) {
        this.intNum = intNum;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("执行时间：" + sf.format(date));

        // 第一种方法使用getJobDetail()和getMergedJobDataMap()获取传入的参数值

        // 获取JobDetail的key:withIdentity()中的第一个参数。
        JobKey key = jobExecutionContext.getJobDetail().getKey();
        // 获取JobData对象，来操作传入的参数，是Map类型
        JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        // 获取usingJobData()传入的数据
        String jobMsg = jobDataMap.getString("msg");
        System.out.println("jobDetail的Name和Group:" + key.getName() + "   " + key.getGroup());
        System.out.println("传入的参数的key为msg,传入的值为:" + jobMsg + "\n");

        // 对Trigger的操作同理
        TriggerKey triggerKey = jobExecutionContext.getTrigger().getKey();
        JobDataMap jobDataMap1 = jobExecutionContext.getTrigger().getJobDataMap();
        String triggerMsg = jobDataMap1.getString("msg");
        System.out.println("trigger的name和group:" + triggerKey.getName() + "   " + triggerKey.getGroup());
        System.out.println("Trigger传入的key为msg，传入的值为:" + triggerMsg + "\n");

        // 使用getMergedJobDataMap()一同获取jobDetail和Trigger中数据
        // 当两个域中的数据的key值相同时 优先使用Trigger中的值
        JobDataMap jobDataMap2 = jobExecutionContext.getMergedJobDataMap();
        String message = jobDataMap2.getString("msg");
        System.out.println("msg的内容为：" + message + "\n");

        System.out.println("使用getter和setter方法  msg = " + msg);
        System.out.println("使用getter和setter方法  intNum = " + intNum);
        System.out.println("-----------------------------");

    }
}
