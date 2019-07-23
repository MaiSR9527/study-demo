package com.gdou.gym.dao;

import com.gdou.gym.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/12 23:42
 */
public interface IRentOrderDao {

    @Insert ("insert into rentorder values (null,#{equipId} ,#{equipName} ,#{userId} ,#{userName} ,#{num} ,#{currentDate} ,#{returnDate} ,#{fee} ,#{orderStatus}  ,#{equipStatus},#{days}   )")
    void save (Order order);

    @Select ("select * from rentorder")
    List<Order> findAll ();

    @Select ("select * from rentorder where orderStatus=#{status} ")
    List<Order> findAllByOrderStatus (String status);

    @Select ("select * from rentorder where equipStatus=#{status} and orderStatus=#{status2} ")
    List<Order> findAllByEquipStatus (@Param ("status") String status, @Param ("status2") String status2);

    @Select ("select * from rentorder where orderId=#{id} ")
    Order findById (int id);

    @Update ("update rentorder set orderStatus=#{status},returnDate = #{date}  where orderId=#{oid} ")
    void updateOrderStatus (@Param ("oid") Integer oid, @Param ("status") String status, @Param ("date") Date date1);

    @Update ("update rentorder set equipStatus=#{status} where orderId=#{oid} ")
    void updateEquipStatus (@Param ("oid") Integer oid, @Param ("status") String status);

    @Select ("select * from rentorder where userId=#{id} ")
    List<Order> findByUserId (int id);

    @Select ("select * from rentorder where userId=#{id} and equipStatus=#{status} and orderStatus=#{status2} ")
    List<Order> findByUserIdReturn (@Param ("id") int id, @Param ("status") String status, @Param ("status2") String status2);

    @Select ("select * from rentorder where userId=#{id} and orderStatus=#{status} ")
    List<Order> findByUserIdRent (@Param ("id") int id, @Param ("status") String status);

    @Select ("select * from rentorder where equipId = #{id} and orderStatus = #{status} ")
    List<Order> findAllPassByEquipId (@Param ("id") int id, @Param ("status") String status);
}
