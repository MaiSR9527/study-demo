package com.gdou.gym.dao;

import com.gdou.gym.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

/**
 * @author maishuren
 * @date 2019/6/10 13:41
 */
public interface IUserDao {

    @Select("select * from user where userName = #{username} ")
//    @Results ({
//            @Result(id = true, property = "userId", column = "userId"),
//            @Result(property = "password", column = "password"),
//            @Result(property = "userName", column = "userName"),
//            @Result(property = "gender", column = "gender"),
//            @Result(property = "specialty", column = "specialty"),
//            @Result(property = "grade", column = "grade"),
//            @Result(property = "collage", column = "collage"),
//            @Result(property = "status", column = "status"),
//            @Result (property = "roles",column = "userId",javaType = java.util.List.class,many = @Many (select = " com.gdou.gym.dao.IRoleDao.findRoleByUserId"))
//    })
    UserInfo findByUsername (String username);

    @Select("select * from user where userId = #{id} ")
    UserInfo findById(String id);
}
