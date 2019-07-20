package com.gdou.msr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author maishuren
 * @date 2019/6/22 16:29
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public String login(String username, String password) {
        return "Hello " + username + ", " + "your password is" + password;
    }
}
