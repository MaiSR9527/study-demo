package com.gdou.msr.shirodemo3.controller;

import com.gdou.msr.shirodemo3.pojo.UserInfo;
import com.gdou.msr.shirodemo3.service.IUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author maishuren
 * @date 2019/6/19 21:19
 */
@Controller
public class TestController {

    @RequestMapping("/login")
    public String login(){

        return "login";
    }

    @RequestMapping("/index")
    public String success(){
        return "success";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null){
            subject.logout();
        }
        return "login";
    }

    @RequestMapping("/admin")
    @ResponseBody
    public String admin(){
        return "admin";
    }

    @RequestMapping("/unauthorized")
    @ResponseBody
    public String unauthorized(){
        return "无权限";
    }

    @RequestMapping("/edit")
    @ResponseBody
    public String edit(){
        return "edit page";
    }
    /**
     * 登录认证
     * @param username 用户名
     * @param password 密码
     * @param session session
     * @return 返回
     */
    @RequestMapping("/loginUser")
    public String loginUser(@RequestParam(name = "username") String username,
                            @RequestParam(name = "password") String password,
                            HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
            UserInfo userInfo = (UserInfo) subject.getPrincipal();
            session.setAttribute("user",userInfo);
            return "success";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "login";
        }
    }
}
