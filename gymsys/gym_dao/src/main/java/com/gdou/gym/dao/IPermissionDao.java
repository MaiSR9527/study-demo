package com.gdou.gym.dao;

import com.gdou.gym.pojo.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/10 16:22
 */
public interface IPermissionDao {

    @Select("select * from permission where permissionId in (select permissionId from role_permission where roleId=#{rId})")
    public List<Permission> findPermissionByRoleId(int rId);
}
