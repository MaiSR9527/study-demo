package com.msr.pojo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import lombok.Data;

/**
 * @author maishuren
 * @date 2019/7/6 22:40
 */
@Data
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer age;

}
