package com.gdou.msr.controller;

import com.gdou.msr.pojo.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maishuren
 * @date 2019/6/18 19:46
 */
@RequestMapping("user")
public class UserController {

    @RequestMapping("login")
    public String login(UserInfo userInfo){
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUsername(),userInfo.getPassword());
            token.setRememberMe(true);
            try{
                currentUser.login(token);
            }
            catch (AuthenticationException ae){
                System.out.println("登录失败");
                System.out.println(ae.getMessage());
            }
        }
        return "success";
    }
}
