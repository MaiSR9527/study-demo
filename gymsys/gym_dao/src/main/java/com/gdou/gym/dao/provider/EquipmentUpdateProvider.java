package com.gdou.gym.dao.provider;

import com.gdou.gym.pojo.Equipment;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author maishuren
 * @date 2019/6/14 22:01
 */
public class EquipmentUpdateProvider extends SQL {
    public static final String TABLE_NAME = "equipment";

    public String updateEquipment(Equipment equipment){
        return new SQL(){
            {
                UPDATE(TABLE_NAME);
                if (equipment.getEquipName() != null){
                    SET("equipName = #{equipName}");
                }
                if (equipment.getEquipName() != null){
                    SET("equipName = #{equipName}");
                }
                if (equipment.getTotalNum() != null){
                    SET("totalNum = #{totalNum}");
                }
                if (equipment.getValidNum() != null){
                    SET("validNum = #{validNum}");
                }
                if (equipment.getMaintainNum() != null){
                    SET("maintainNum = #{maintainNum}");
                }if (equipment.getRentedNum() != null){
                    SET("rentedNum = #{rentedNum}");
                }if (equipment.getPrice() != null){
                    SET("price = #{price}");
                }
                WHERE("equipId = "+equipment.getEquipId());
            }
        }.toString();
    }

}
