package com.gdou.msr.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * @author maishuren
 * @date 2019/6/22 20:19
 */
@Component("myBean")
public class MyBean {
    public void printMessage() {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("MyBean Executes!" + sf.format(date));
    }
}
