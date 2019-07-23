package com.gdou.gym.service;

import com.gdou.gym.pojo.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**  extends UserDetailsService
 * @author maishuren
 * @date 2019/6/10 11:49
 */
public interface IUserService {
    public List<UserInfo> findAll();
    public void saveUser(UserInfo userInfo);
    public UserInfo findById(String id);
}
