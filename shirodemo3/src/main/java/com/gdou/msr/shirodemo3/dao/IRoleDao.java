package com.gdou.msr.shirodemo3.dao;

import com.gdou.msr.shirodemo3.pojo.Role;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/19 22:40
 */
public interface IRoleDao {
    /**
     *
     * @param uid
     * @return
     */
    @Select("select * from role where rid in (select rid from user_role where uid=#{uid} )")
    @Results({
            @Result(id = true,property = "rid",column = "rid"),
            @Result(property ="rname",column = "rname"),
            @Result(property = "permissions",column = "rid",javaType = java.util.List.class,many = @Many(select = "com.gdou.msr.shirodemo3.dao.IPermission.findPermissionByRoleId"))
    })
    public List<Role> findRoleByUserId(Integer uid);
}
