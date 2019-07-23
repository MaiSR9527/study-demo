package com.gdou.gym.service.impl;

import com.gdou.gym.dao.IRentOrderDao;
import com.gdou.gym.pojo.Order;
import com.gdou.gym.service.IRentOrderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/12 23:51
 */
@Service
@Transactional (rollbackFor = Exception.class)
public class RentOrderImpl implements IRentOrderService {

    @Autowired
    private IRentOrderDao rentOrderDao;

    @Override
    public void save (Order order) {
        rentOrderDao.save(order);
    }

    @Override
    public List<Order> findAll (int page, int size) {
        PageHelper.startPage(page,size);
        return rentOrderDao.findAll();
    }

    @Override
    public List<Order> findAllByOrderStatus (int page, int size,String status) {
        PageHelper.startPage(page,size);
        return rentOrderDao.findAllByOrderStatus(status);
    }

    @Override
    public List<Order> findAllByEquipStatus (int page, int size, String status,String status2) {
        PageHelper.startPage(page,size);
        return rentOrderDao.findAllByEquipStatus(status,status2);
    }

    @Override
    public Order findById (int id) {
        return rentOrderDao.findById(id);
    }

    @Override
    public void updateOrderStatus (Integer oid, String status, Date date1) {
        rentOrderDao.updateOrderStatus(oid,status,date1);
    }

    @Override
    public void updateEquipStatus (Integer oid, String status) {
        rentOrderDao.updateEquipStatus(oid,status);
    }

    @Override
    public List<Order> findByUserId (int id,int page,int size) {
        PageHelper.startPage(page,size);
        return rentOrderDao.findByUserId(id);
    }

    @Override
    public List<Order> findByUserIdReturn (int id, int page, int size) {
        String status = "未归还";
        String status2 = "已审核";
        PageHelper.startPage(page,size);
        return rentOrderDao.findByUserIdReturn(id,status,status2);
    }

    @Override
    public List<Order> findByUserIdRent (int id,int page,int size) {
        String status = "未审核";
        PageHelper.startPage(page,size);
        return rentOrderDao.findByUserIdRent(id,status);
    }

    @Override
    public List<Order> findAllPassByEquipId (int id, String status, int page, int size) {
        PageHelper.startPage(page,size);

        return rentOrderDao.findAllPassByEquipId(id,status);
    }
}
