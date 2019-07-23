package com.gdou.gym.service;

import com.gdou.gym.pojo.Order;

import java.util.Date;
import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/12 23:51
 */
public interface IRentOrderService {

    void save (Order order);

    List<Order> findAll (int page, int size);

    List<Order> findAllByOrderStatus (int page, int size,String status);

    List<Order> findAllByEquipStatus (int page, int size,String status,String status2);

    Order findById (int id);

    void updateOrderStatus (Integer oid, String status, Date date1);

    void updateEquipStatus (Integer oid, String status);

    List<Order> findByUserIdReturn (int id, int page, int size);

    List<Order> findByUserId (int id, int page, int size);

    List<Order> findByUserIdRent (int id, int page, int size);

    List<Order> findAllPassByEquipId (int id, String status, int page, int size);
}
