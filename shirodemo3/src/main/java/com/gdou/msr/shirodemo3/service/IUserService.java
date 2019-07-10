package com.gdou.msr.shirodemo3.service;

import com.gdou.msr.shirodemo3.pojo.UserInfo;

/**
 * @author maishuren
 * @date 2019/6/19 16:02
 */
public interface IUserService {

    UserInfo findByUserName(String username);
}
