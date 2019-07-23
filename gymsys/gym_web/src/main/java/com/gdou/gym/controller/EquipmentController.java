package com.gdou.gym.controller;

import com.gdou.gym.pojo.Equipment;
import com.gdou.gym.pojo.Maintain;
import com.gdou.gym.service.IEquipmentService;
import com.gdou.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/2 10:40
 */
@Controller
@RequestMapping ("/equipment")
public class EquipmentController {

    @Autowired
    private IEquipmentService equipmentService;

    private DateUtils dateUtils;

    @RequestMapping ("findAll.do")
    public ModelAndView findAll (
            @RequestParam (name = "page", required = true, defaultValue = "1") int currentPage,
            @RequestParam (name = "size", required = true, defaultValue = "4") int size)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Equipment> equipments = equipmentService.findAll(currentPage, size);
        PageInfo pageInfo = new PageInfo(equipments);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("equipments-page-list");
        return modelAndView;
    }

    /**
     * 器材租借
     *
     * @param id 器材id
     * @return 器材租借
     */
    @RequestMapping ("rentOrder.do")
    public ModelAndView rentById (@RequestParam (name = "eid", required = true) int id) {
        ModelAndView mv = new ModelAndView();
        Equipment equipment = equipmentService.findById(id);
        String orderTime = DateUtils.date2String(new Date(), "yyyy-MM-dd");
        mv.addObject("orderTime", orderTime);
        mv.addObject("equipment", equipment);
        mv.setViewName("equipment-order");
        return mv;
    }

    /**
     * 根据器材名称查询器材
     *
     * @param currentPage 当前页
     * @param size        每页条数
     * @param name        名称
     * @return 返回ModelAndView对象
     * @throws Exception 抛出异常
     */
    @RequestMapping ("findByName.do")
    public ModelAndView findByName (
            @RequestParam (name = "page", required = true, defaultValue = "1") int currentPage,
            @RequestParam (name = "size", required = true, defaultValue = "4") int size,
            @RequestParam (name = "name", required = true) String name)
            throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Equipment> equipments = equipmentService.findByName(currentPage, size, name);
        PageInfo pageInfo = new PageInfo(equipments);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("equipment-query");
        return mv;
    }

    /**
     * 保存新器材
     *
     * @param equipment 保存新器材
     * @return 保存新器材
     */
    @RequestMapping ("/save.do")
    public String save (Equipment equipment) {
        equipmentService.save(equipment);
        return "redirect:findAll.do";
    }

    /**
     * 根据器材id删除器材
     *
     * @param id 根据器材id删除器材
     * @return 根据器材id删除器材
     */
    @RequestMapping ("/deleteById.do")
    public String deleteById (@RequestParam (name = "eid", required = true) int id) {
        equipmentService.deleteById(id);
        return "redirect:findAll.do";
    }

    /**
     * 器材查询
     *
     * @param page 当前页
     * @param size 每页数量
     * @return 返回ModelAndView对象
     * @throws Exception 抛出异常
     */
    @RequestMapping ("commonFindAll.do")
    public ModelAndView commonFindAll (
            @RequestParam (name = "page", required = true, defaultValue = "1") int page,
            @RequestParam (name = "size", required = true, defaultValue = "4") int size)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Equipment> equipments = equipmentService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(equipments);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("equipment-query");
        return modelAndView;
    }

    /**
     * 批量删除
     *
     * @param ids 批量删除
     * @return 批量删除
     */
    @RequestMapping ("/deleteItem.do")
    public String deleteItem (Integer[] ids) {
        for (Integer id : ids) {
            // 批量删除
            equipmentService.deleteById(id);
        }
        return "redirect:findAll.do";
    }

    /**
     * 租借查询
     *
     * @param page 租借查询
     * @param size 租借查询
     * @return 租借查询
     * @throws Exception 异常
     */
    @RequestMapping ("/rentFindAll.do")
    public ModelAndView rentFindAll (
            @RequestParam (name = "page", required = true, defaultValue = "1") int page,
            @RequestParam (name = "size", required = true, defaultValue = "4") int size)
            throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Equipment> equipments = equipmentService.findAll(page, size);
        PageInfo pageInfo = new PageInfo(equipments);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("equipment-rent");
        return modelAndView;
    }

    @RequestMapping ("/updateNum.do")
    public String updateNum (
            @RequestParam (name = "id", required = true) int id,
            @RequestParam (name = "num", required = true) int num) {
        equipmentService.updateRentedNum(id, num);
        Equipment byId = equipmentService.findById(id);
        int nowNum = byId.getValidNum() - num;
        equipmentService.updateValidNum(id, nowNum);

        return "redirect:/order/findAll.do?page=1&size=4";
    }

    @RequestMapping ("/returnEquipment.do")
    public String returnEquipment (
            @RequestParam (name = "id", required = true) int id,
            @RequestParam (name = "num", required = true) int num) {
        Equipment equipment = equipmentService.findById(id);
        int nowRentedNum = equipment.getRentedNum() - num;
        int nowValidNum = equipment.getValidNum() + num;
        equipmentService.updateRentedNum(id, nowRentedNum);
        equipmentService.updateValidNum(id, nowValidNum);

        return "redirect:/order/findAll.do?page=1&size=4";
    }

    @RequestMapping ("/modifyEquipment.do")
    public String modifyEquipment (Equipment equipment) {
        equipmentService.updateEquipment(equipment.getEquipId(), equipment);
        return "redirect:findAll.do";
    }

    @RequestMapping ("/modifyForm.do")
    public ModelAndView modifyForm (@RequestParam (name = "id", required = true) int id) {
        ModelAndView modelAndView = new ModelAndView();
        Equipment equipment = equipmentService.findById(id);
        modelAndView.addObject("equipment", equipment);
        modelAndView.setViewName("equipment-edit");
        return modelAndView;
    }

    @RequestMapping ("/maintainEquip.do")
    public ModelAndView maintainEquip (@RequestParam (name = "id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Equipment maintainEquipment = equipmentService.findById(id);
        Date date = new Date();
        String date2String = DateUtils.date2String(date, "yyyy-MM-dd");
        modelAndView.addObject("maintainEquipment", maintainEquipment);
        modelAndView.addObject("time", date2String);
        modelAndView.setViewName("equipment-maintain");
        return modelAndView;
    }

    @RequestMapping ("/saveMaintain.do")
    public String saveMaintain (Maintain maintain) {
        equipmentService.saveMaintain(maintain);
        Equipment equipment = equipmentService.findById(maintain.getEquipId());
        Integer maintainNum = equipment.getMaintainNum();
        Integer validNum = equipment.getValidNum();
        equipmentService.updateMaintainNum(maintain.getEquipId(), maintainNum + (maintain.getMaintainNum()), validNum - maintain.getMaintainNum());
        return "redirect:maintainFindAll.do?page=1&size=4";
    }

    @RequestMapping ("/maintainFindAll.do")
    public ModelAndView maintainFindAll (@RequestParam (name = "page") Integer page, @RequestParam (name = "size") Integer size) {
        ModelAndView modelAndView = new ModelAndView();
        List<Maintain> allMaintain = equipmentService.findAllMaintain(page, size);
        PageInfo pageInfo = new PageInfo(allMaintain);
        modelAndView.addObject("pageInfo", pageInfo);
        modelAndView.setViewName("equipment-maintain-list");
        return modelAndView;
    }

    @RequestMapping ("/maintainFinish.do")
    public String maintainFinish (Integer id) {
        String finished = "已完成";
        equipmentService.updateMaintainStatus(id, finished);
        Maintain maintain = equipmentService.findByMId(id);
        Equipment equipment = equipmentService.findById(maintain.getEquipId());
        int finalNum = equipment.getValidNum()+ maintain.getMaintainNum();
        equipmentService.updateValidNum(equipment.getEquipId(),finalNum);
        return "redirect:maintainFindAll.do?page=1&size=4";
    }

    @RequestMapping ("/queryFinished.do")
    public ModelAndView queryFinished (@RequestParam (name = "page") Integer page,
                                       @RequestParam (name = "size") Integer size) {
        String status = "已完成";
        List<Maintain> maintainList = equipmentService.queryFinished(status, page, size);
        PageInfo pageInfo = new PageInfo(maintainList);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("equipment-maintain-list");
        return modelAndView;
    }
}
