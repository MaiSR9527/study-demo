package com.gdou.msr.shirodemo3;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.gdou.msr.shirodemo3.dao"})

public class Shirodemo3Application {

    public static void main (String[] args) {
        SpringApplication.run(Shirodemo3Application.class, args);
    }

}
