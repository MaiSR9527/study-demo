package com.gdou.gym.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/5/30 22:26
 */
@Data
public class UserInfo {
    private String userId;
    private String password;
    private String userName;
    private String gender;
    // 专业
    private String specialty;
    // 班级
    private String grade;
    // 学院
    private String college;
    // 状态
    private int status;

    private List<Role> roles;
}
