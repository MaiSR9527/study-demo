package com.gdou.msr.quartz;

import org.springframework.stereotype.Component;

/**
 * @author maishuren
 * @date 2019/6/22 20:21
 */
@Component("anotherBean")
public class AnotherBean {

    public void printAnotherMessage() {
        System.out.println("AnotherMessage");
    }
}
