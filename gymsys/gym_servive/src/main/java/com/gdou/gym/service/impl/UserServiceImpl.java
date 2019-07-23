package com.gdou.gym.service.impl;

import com.gdou.gym.dao.IPermissionDao;
import com.gdou.gym.dao.IRoleDao;
import com.gdou.gym.dao.IUserDao;
import com.gdou.gym.pojo.Permission;
import com.gdou.gym.pojo.Role;
import com.gdou.gym.pojo.UserInfo;
import com.gdou.gym.service.IUserService;
import com.gdou.utils.BCryptPasswordEncoderUtils;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/10 12:16
 */
@Service("userService")
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Override
    public List<UserInfo> findAll () {
        return null;
    }

    @Override
    public void saveUser (UserInfo userInfo) {

    }

    @Override
    public UserInfo findById (String id) {
        return userDao.findById(id);
    }



    /*@Autowired
    private IUserDao userDao;

    @Autowired
    private IRoleDao roleDao;

    @Autowired
    private IPermissionDao permissionDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        List<Role> listRole = null;
        List<Permission> permissions = null;
        try {
            userInfo = userDao.findByUsername(username);
            listRole = roleDao.findRoleByUserId(userInfo.getUserId());
//            for (Role role : listRole) {
//                permissions = permissionDao.findPermissionByRoleId(role.getRoleId());
//                listRole.get(0).setPermissions(permissions);
//            }
            userInfo.setRoles(listRole);
            System.out.println(userInfo.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        User user = new User(userInfo.getUserName(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
        return user;
    }

    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            System.out.println(role.toString());
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }


    @Override
    public List<UserInfo> findAll () {
        return null;
    }

    @Override
    public void saveUser (UserInfo userInfo) {
        // 密码加密
        userInfo.setPassword(BCryptPasswordEncoderUtils.encoderPassword(userInfo.getPassword()));
    }

    @Override
    public UserInfo findById (String id) {
        return null;
    }*/
}
