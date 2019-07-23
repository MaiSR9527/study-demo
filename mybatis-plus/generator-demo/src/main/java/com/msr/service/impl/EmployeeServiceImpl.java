package com.msr.service.impl;

import com.msr.pojo.Employee;
import com.msr.mapper.EmployeeMapper;
import com.msr.service.EmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author maishuren
 * @since 2019-07-08
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    /*
    * 因为继承了ServiceImpl，所以不用再注入mapper对象
    * 也提供了一些CRUD的函数
    * */
}
