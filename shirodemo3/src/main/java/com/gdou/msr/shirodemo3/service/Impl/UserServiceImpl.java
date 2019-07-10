package com.gdou.msr.shirodemo3.service.Impl;

import com.gdou.msr.shirodemo3.dao.IUserDao;
import com.gdou.msr.shirodemo3.pojo.UserInfo;
import com.gdou.msr.shirodemo3.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author maishuren
 * @date 2019/6/19 16:02
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDao;

    @Override
    public UserInfo findByUserName (String username) {
        return userDao.findByUserName(username);
    }
}
