package com.gdou.msr.shirodemo3.dao;

import com.gdou.msr.shirodemo3.pojo.UserInfo;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/19 16:00
 */
public interface IUserDao {

    @Select("select * from userinfo where username=#{username} ")
    @Results({
            @Result(id = true,property = "uid",column = "uid"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "roles",column = "uid",javaType = java.util.List.class,many = @Many(select = "com.gdou.msr.shirodemo3.dao.IRoleDao.findRoleByUserId"))
    })
    public UserInfo findByUserName(String username);
}
