package com.gdou.gym.dao;

import com.gdou.gym.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/10 16:01
 */
public interface IRoleDao {

    @Select("select * from role where roleId in (select roleId from user_role where userId = #{userId} )")
    @Results ({
            @Result (id = true,property = "roleId",column = "roleId"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "roleId",javaType = java.util.List.class,many = @Many (select = "com.gdou.gym.dao.IPermissionDao.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId);
}
