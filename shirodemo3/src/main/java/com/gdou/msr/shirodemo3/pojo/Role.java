package com.gdou.msr.shirodemo3.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/19 15:55
 */
@Data
public class Role {

    private Integer rid;

    private String rname;

    private List<Permission> permissions;

}
