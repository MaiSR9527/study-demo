package com.gdou.gym.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/5/30 22:47
 */
@Data
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleDesc;
    private List<UserInfo> userInfo;
    private List<Permission> permissions;
}
