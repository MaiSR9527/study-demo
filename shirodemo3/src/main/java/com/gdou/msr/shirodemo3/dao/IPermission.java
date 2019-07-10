package com.gdou.msr.shirodemo3.dao;

import com.gdou.msr.shirodemo3.pojo.Permission;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/19 22:43
 */
public interface IPermission {

    @Select("select * from permission where pid in (select pid from permission_role where rid = #{rid} )")
    public List<Permission> findPermissionByRoleId(Integer rid);
}
