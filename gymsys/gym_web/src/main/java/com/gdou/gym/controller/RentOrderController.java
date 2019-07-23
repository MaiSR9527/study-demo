package com.gdou.gym.controller;

import com.gdou.gym.pojo.Order;
import com.gdou.gym.service.IRentOrderService;
import com.gdou.utils.DateUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author maishuren
 * @date 2019/6/12 22:28
 */
@Controller
@RequestMapping("/order")
public class RentOrderController {

    @Autowired
    private IRentOrderService rentOrderService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page",required = true)int page,
                                @RequestParam(name = "size",required = true)int size){
        ModelAndView view = new ModelAndView();
        List<Order> orders = rentOrderService.findAll(page,size);
        PageInfo info = new PageInfo(orders);
        view.addObject("pageInfo",info);
        view.setViewName("order-page-list");
        System.out.println(orders);
        return view;
    }

    @RequestMapping("/save.do")
    public String save(Order order){
        order.setOrderStatus("未审核");
        order.setEquipStatus("未归还");
        rentOrderService.save(order);
        return "redirect:/equipment/rentFindAll.do";
    }

    @RequestMapping("/findAllByOrderStatus.do")
    public ModelAndView findAllByOrderStatus(@RequestParam(name = "page", required = true)int page,
                                             @RequestParam(name = "size",required = true)int size){
        ModelAndView modelAndView = new ModelAndView();
        String status = "未审核";
        List<Order> orders = rentOrderService.findAllByOrderStatus(page,size,status);
        PageInfo pageInfo = new PageInfo(orders);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("order-judge-rent");
        return modelAndView;
    }

    @RequestMapping("/findAllByEquipStatus.do")
    public ModelAndView findAllByEquipStatus(@RequestParam(name = "page", required = true)int page,
                                             @RequestParam(name = "size",required = true)int size){
        ModelAndView modelAndView = new ModelAndView();
        String status = "未归还";
        String status2 = "已审核";
        List<Order> orders = rentOrderService.findAllByEquipStatus(page,size,status,status2);
        PageInfo pageInfo = new PageInfo(orders);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("order-judge-return");
        return modelAndView;
    }

    @RequestMapping("/findByIdReturn.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)int id){
        ModelAndView modelAndView = new ModelAndView();
        Order order = rentOrderService.findById(id);
        modelAndView.addObject("order",order);
        modelAndView.setViewName("order-pass-return");
        return modelAndView;
    }

    @RequestMapping("/findByIdRent.do")
    public ModelAndView findByIdRent(@RequestParam(name = "id",required = true)int id){
        ModelAndView modelAndView = new ModelAndView();
        Order order = rentOrderService.findById(id);
        modelAndView.addObject("order",order);
        modelAndView.setViewName("order-pass-rent");
        return modelAndView;
    }

    @RequestMapping("/updateOrderStatus.do")
    public String updateOrderStatus(Order order) throws ParseException {
        Integer id = order.getEquipId();
        Integer num = order.getNum();
        Integer oid = order.getOrderId();
        String status = order.getOrderStatus();
        Integer days = order.getDays();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(new Date(date.getTime()+(long)days*24 * 60 * 60 * 1000));
        Date date1 = DateUtils.string2Date(format, "yyyy-MM-dd");
        rentOrderService.updateOrderStatus(oid,status,date1);
//        return null;
        return "redirect:/equipment/updateNum.do?id="+id+"&num="+num;
    }

    @RequestMapping("/updateEquipStatus.do")
    public String updateEquipStatus(Order order){
        Integer id = order.getEquipId();
        Integer num = order.getNum();
        Integer oid = order.getOrderId();
        String status = order.getEquipStatus();
        rentOrderService.updateEquipStatus(oid,status);
//        return null;
        return "redirect:/equipment/returnEquipment.do?id="+id+"&num="+num;
    }

    @RequestMapping("/findByUserId.do")
    public ModelAndView findByUserId(@RequestParam(name = "id",required = true)int id,
                                     @RequestParam(name = "page",required = true)int page,
                                     @RequestParam(name = "size",required = true)int size){
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orders = rentOrderService.findByUserId(id,page,size);
        PageInfo pageInfo = new PageInfo(orders);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("order-page-list");
        return modelAndView;
    }

    @RequestMapping("/findByUserIdReturn.do")
    public ModelAndView findByUserIdReturn(@RequestParam(name = "id",required = true)int id,
                                     @RequestParam(name = "page",required = true)int page,
                                     @RequestParam(name = "size",required = true)int size){
        ModelAndView modelAndView =new ModelAndView();
        List<Order> orders = rentOrderService.findByUserIdReturn(id, page, size);
        PageInfo pageInfo = new PageInfo(orders);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("order-judge-return");
        return modelAndView;
    }

    @RequestMapping("/findByUserIdRent.do")
    public ModelAndView findByUserIdRent(@RequestParam(name = "id",required = true)int id,
                                     @RequestParam(name = "page",required = true)int page,
                                     @RequestParam(name = "size",required = true)int size){
        ModelAndView modelAndView =new ModelAndView();
        List<Order> orders = rentOrderService.findByUserIdRent(id, page, size);
        PageInfo pageInfo = new PageInfo(orders);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("order-judge-rent");
        return modelAndView;
    }

    @RequestMapping("/findAllPass.do")
    public ModelAndView findAllPass(@RequestParam(name = "id",required = true) int id,
                                    @RequestParam(name = "page",required = true)int page,
                                    @RequestParam(name = "size",required = true)int size){
        ModelAndView modelAndView = new ModelAndView();
        String status = "已审核";
        List<Order> orders = rentOrderService.findAllPassByEquipId(id,status,page,size);
        PageInfo pageInfo = new PageInfo(orders);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("order-judge-rent");
        return modelAndView;
    }
}
