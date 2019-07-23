package com.gdou.gym.pojo;

import com.gdou.utils.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

/**
 * @author maishuren
 * @date 2019/6/8 16:19
 */
@Data
public class Order {

    private Integer orderId;
    private Integer equipId;
    private String equipName;
    private String userId;
    private String userName;
    private Integer num;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date currentDate;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private Date returnDate;
    private Integer fee;
    private String orderStatus;
    private String equipStatus;
    private Integer days;
    private UserInfo userInfo;
    private Equipment equipment;
    private String currentDateStr;
    private String returnDateStr;

    public String getCurrentDateStr () {
        if (currentDate != null){
            currentDateStr = DateUtils.date2String(currentDate,"yyyy-MM-dd");
        }
        return currentDateStr;
    }

    public String getReturnDateStr () {
        if (returnDate != null){
            returnDateStr = DateUtils.date2String(returnDate,"yyyy-MM-dd");
        }
        return returnDateStr;
    }
}
