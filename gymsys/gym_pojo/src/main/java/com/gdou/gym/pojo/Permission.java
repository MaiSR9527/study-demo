package com.gdou.gym.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/10 10:22
 */
@Data
public class Permission {

    private Integer permissionId;
    private String permissionName;
    private String url;
    private List<Role> roles;
}
