package com.gdou.gym.service.impl;

import com.gdou.gym.dao.IEquipmentDao;
import com.gdou.gym.pojo.Equipment;
import com.gdou.gym.pojo.Maintain;
import com.gdou.gym.service.IEquipmentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/2 10:54
 */
@Service
@Transactional (rollbackFor = Exception.class)
public class EquipmentServiceImpl implements IEquipmentService {

    @Autowired
    private IEquipmentDao equipmentDao;

    @Override
    public List<Equipment> findAll (int page, int size) throws Exception {

        PageHelper.startPage(page, size);
        return equipmentDao.findALl();
    }

    @Override
    public Equipment findById (int id) {
        return equipmentDao.findById(id);
    }

    @Override
    public List<Equipment> findByName (int currentPage, int size, String name) {
        PageHelper.startPage(currentPage, size);
        return equipmentDao.findByName(name);
    }

    @Override
    public void save (Equipment equipment) {
        equipmentDao.save(equipment);
    }

    @Override
    public void deleteById (int id) {
        equipmentDao.deleteById(id);
    }

    @Override
    public void updateRentedNum (int id, int num) {
        equipmentDao.updateRentedNum(id, num);
    }

    @Override
    public void updateValidNum (int id, int num) {
        equipmentDao.updateValidNum(id, num);
    }

    @Override
    public void updateEquipment (Integer equipId, Equipment equipment) {
        equipmentDao.updateEquipment(equipment);
    }

    @Override
    public void saveMaintain (Maintain maintain) {
        equipmentDao.saveMaintain(maintain);
    }

    @Override
    public void updateMaintainNum (Integer id, Integer num ,Integer vnum) {
        equipmentDao.updateMaintainNum(id,num,vnum);
    }

    @Override
    public List<Maintain> findAllMaintain (Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return equipmentDao.findAllMaintain();
    }

    @Override
    public int queryTotalNum (Integer id) {
        return equipmentDao.queryTotalNum(id);
    }

    @Override
    public void updateMaintainStatus (Integer id, String finished) {
        equipmentDao.updateMaintainStatus(id,finished);
    }

    @Override
    public List<Maintain> queryFinished (String status, Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return equipmentDao.queryFinished(status);
    }

    @Override
    public Maintain findByMId (Integer id) {
        return equipmentDao.findByMId(id);
    }
}
