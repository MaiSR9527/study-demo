package com.msr.testDemo;

import javax.annotation.Resource;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.msr.dao.EmployeeMapper;
import com.msr.pojo.Employee;

import java.util.*;

/**
 * @author maishuren
 * @date 2019/7/7 10:13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestDemo {

    @Resource
    private EmployeeMapper employeeMapper;

    @Test
    public void testInsert(){
        Employee employee = new Employee();
//        employee.setAge(25);
        employee.setEmail("helloworld@163.com");
        employee.setGender(0);
        employee.setLastName("hello");
        // insert方法相当于动态sql语句中的判空操作，没有设置初值的字段不会插入数据
        int row = employeeMapper.insert(employee);
//        employeeMapper.
        Assert.assertEquals(1,row);
    }

    @Test
    public void testUpdate(){
        Employee employee = new Employee();
//        employee.setAge(25);
        employee.setId(9);
        employee.setEmail("125413548@163.com");
        employee.setGender(1);
        employee.setLastName("marry");
        // insert方法相当于动态sql语句中的判空操作，没有设置初值的字段不会插入数据
        int row = employeeMapper.updateById(employee);
//        employeeMapper.
        Assert.assertEquals(1,row);
    }

    @Test
    public void testSelect(){
        Employee employee = new Employee();
        employee.setId(6);
        employee.setGender(1);
        Employee employee1 = employeeMapper.selectById(6);
        System.out.println(employee1);

        Map<String,Object> colMap = new HashMap<>();
        colMap.put("last_name","jack");
        colMap.put("gender",1);
        employeeMapper.selectByMap(colMap);
    }

    @Test
    public void testQueryWrapper(){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age",21,30)
                    .orderByAsc("age");

//        List<Employee> employees = employeeMapper.selectList(null);查询所有
        // 条件查询
        List<Employee> employees = employeeMapper.selectList(queryWrapper);
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Test
    public void testUpdateWrapper(){

        UpdateWrapper<Employee> updateWrapper = new UpdateWrapper<>();
        updateWrapper.isNull("age");
        Employee employee = new Employee();
        employee.setAge(new Random().nextInt(100));
        employeeMapper.update(employee,updateWrapper);
    }

    @Test
    public void testPage(){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("age");
        // 使用page对象都是基于内存查询的，并不是通过sql语句的limit来查询的
        Page<Employee> employeeIPage = (Page<Employee>) employeeMapper.selectPage(new Page<>(2, 2), queryWrapper);
        List<Employee> records = employeeIPage.getRecords();
        for (Employee record : records) {
            System.out.println(record.toString());
        }
    }

    /**
     * 测试分页插件
     */
    @Test
    public void testPageInterceptor(){

        Page<Employee> employeePage = (Page<Employee>) employeeMapper.selectPage(new Page<>(1,3), null);

        List<Employee> employees = employeePage.getRecords();
        boolean next = employeePage.hasNext();
        boolean previous = employeePage.hasPrevious();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        System.out.println(next+"    "+previous);
        System.out.println("总数："+employeePage.getTotal());
    }


}
