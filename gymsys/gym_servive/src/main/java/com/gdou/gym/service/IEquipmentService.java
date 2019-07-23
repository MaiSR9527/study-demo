package com.gdou.gym.service;

import java.util.List;

import com.gdou.gym.pojo.Equipment;
import com.gdou.gym.pojo.Maintain;

/**
 * @author maishuren
 * @date 2019/6/2 10:49
 */
public interface IEquipmentService {
  /**
   * 查询所有器材
   *
   * @param page 页码值
   * @param size 每页数量
   * @return 返回器材的List集合
   * @throws Exception 抛出异常
   */
  List<Equipment> findAll(int page, int size) throws Exception;

  /**
   * 根据器材ID查询器材信息
   *
   * @param id 传进一个器材ID
   * @return 返回一个Equipment对象
   */
  Equipment findById(int id);

  List<Equipment> findByName(int currentPage, int size, String name);

  void save(Equipment equipment);

  void deleteById(int id);

  void updateRentedNum(int id, int num);

  void updateValidNum(int id, int num);

  void updateEquipment(Integer equipId, Equipment equipment);

  void saveMaintain(Maintain maintain);

  void updateMaintainNum (Integer id, Integer num,Integer vnum);

  List<Maintain> findAllMaintain (Integer page, Integer size);

  int queryTotalNum(Integer id);

  void updateMaintainStatus (Integer id, String finished);

  List<Maintain> queryFinished (String status, Integer page, Integer size);

  Maintain findByMId (Integer id);
}
