package com.gdou.msr.shirodemo3.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/19 15:56
 */
@Data
public class UserInfo {

    private Integer uid;

    private String username;

    private String password;

    private List<Role> roles;

}
