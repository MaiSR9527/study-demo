package com.gdou.gym.pojo;

import lombok.Data;

/**
 * @author maishuren
 * @date 2019/5/31 16:25
 */
@Data
public class Equipment {

    private Integer equipId;
    private String equipName;
    private Integer totalNum;
    /**
     * validNum 可以租借的数量
     */
    private Integer validNum;
    /**
     * maintainNum 维护的器材的数量
     */
    private Integer maintainNum;

    private Integer rentedNum;

    private Integer price;
}
