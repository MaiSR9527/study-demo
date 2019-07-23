package com.gdou.gym.pojo;

import com.gdou.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author maishuren
 * @date 2019/6/24 12:08
 */
@Data
public class Maintain {

    private Integer id;
    private Integer equipId;
    private String equipName;
    private Float totalCost;

    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date endTime;

    private String status;
    private String startTimeStr;
    private String endTimeStr;
    private Integer maintainNum;

    public String getStartTimeStr () {
        if (startTime != null) {
            startTimeStr = DateUtils.date2String(startTime, "yyyy-MM-dd");
        }
        return startTimeStr;
    }

    public String getEndTimeStr () {
        if (endTime != null) {
            endTimeStr = DateUtils.date2String(endTime, "yyyy-MM-dd");
        }
        return endTimeStr;
    }
}
