package com.gdou.gym.controller;

import com.gdou.gym.pojo.UserInfo;
import com.gdou.gym.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author maishuren
 * @date 2019/6/27 18:53
 */
@Controller
@RequestMapping ("/user")
public class UserInfoController {

    @Autowired
    private IUserService userService;

    @RequestMapping ("/login.do")
    public ModelAndView login (@RequestParam (name = "userId") String userId,
                               @RequestParam (name = "password") String password,
                               HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(userId);
        HttpSession session = request.getSession();
        if (userInfo == null) {
            request.setAttribute("errorMsg", "用户不存在");
            mv.setViewName("login");
        } else if (!userInfo.getPassword().equals(password)) {
            request.setAttribute("errorMsg", "密码错误");
            mv.setViewName("login");
        } else {
            session.setAttribute("userInfo",userInfo);
            mv.addObject(userInfo);
            mv.setViewName("main");
        }
        return mv;
    }

    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        request.setAttribute("errorMsg","你已退出登录");
        return "login";
    }
}
