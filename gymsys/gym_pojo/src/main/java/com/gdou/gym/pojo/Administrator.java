package com.gdou.gym.pojo;

import lombok.Data;

/**
 * @author maishuren
 * @date 2019/5/30 22:50
 */
@Data
public class Administrator {
    private String adminId;
    private String adminName;
    private String password;
    private Role role;
}
