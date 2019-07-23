package com.gdou.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author maishuren
 * @date 2019/6/11 10:08
 */
public class BCryptPasswordEncoderUtils {
    public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encoderPassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main (String[] args) {
        System.out.println(encoderPassword("123"));
//        $2a$10$wUX0YN2EXLZxEe.p41g1i.M0/KHFo7moACfumWIV20PnrL7ojsrQe

    }
}
