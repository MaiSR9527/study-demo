package com.msr.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.msr.pojo.Employee;

/**
 * mapper接口,基于Mybatis-Plus实现
 * 需要继承BaseMapper接口,提供泛型即所操作的
 * @author maishuren
 * @date 2019/7/7 10:01
 */
public interface EmployeeMapper extends BaseMapper<Employee> {
}
