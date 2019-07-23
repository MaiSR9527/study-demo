package com.gdou.gym.dao;

import com.gdou.gym.dao.provider.EquipmentUpdateProvider;
import com.gdou.gym.pojo.Equipment;
import com.gdou.gym.pojo.Maintain;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/2 11:05
 */
public interface IEquipmentDao {

    @Select ("select * from equipment")
    List<Equipment> findALl () throws Exception;

    @Select ("select * from equipment where equipId =#{id}")
    Equipment findById (int id);

    @Select ("select * from equipment where equipName like CONCAT('%',#{name},'%') ")
    List<Equipment> findByName (String name);

    @Insert (
            "insert into equipment values (null ,#{equipName} ,#{totalNum} ,#{validNum} ,#{maintainNum} ,#{rentedNum} ,#{price} )")
    void save (Equipment equipment);

    @Delete ("delete from equipment where equipId = #{id} ")
    void deleteById (int id);

    @Update ("update equipment set rentedNum=#{num} where equipId = #{id}")
    void updateRentedNum (@Param ("id") int id, @Param ("num") int num);

    @Update ("update equipment set validNum=#{num} where equipId = #{id} ")
    void updateValidNum (@Param ("id") int id, @Param ("num") int num);

    @UpdateProvider (type = EquipmentUpdateProvider.class, method = "updateEquipment")
    void updateEquipment (Equipment equipment);

    @Insert (
            "insert into maintain (equipId,equipName,totalCost,startTime,endTime,maintainNum) values (#{equipId} ,#{equipName} ,#{totalCost} ,#{startTime} ,#{endTime} ,#{maintainNum} )")
    void saveMaintain (Maintain maintain);

    @Update ("update equipment set maintainNum = #{num} , validNum = #{vnum}  where equipId = #{id} ")
    void updateMaintainNum (@Param ("id") Integer id, @Param ("num") Integer num,@Param("vnum") Integer vnum);

    @Select ("select * from maintain where status = '未完成'")
    List<Maintain> findAllMaintain();

    @Select("select validNum from equipment where id=")
    int queryTotalNum(Integer id);

    @Update("update maintain set status = #{finished} where id = #{id} ")
    void updateMaintainStatus (@Param("id") Integer id,@Param("finished") String finished);

    @Select("select * from maintain where status = #{status} ")
    List<Maintain> queryFinished (String status);

    @Select("select * from maintain where id = #{id} ")
    Maintain findByMId (Integer id);
}
