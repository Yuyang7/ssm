package com.atguigu.ssm.service.impl;

import com.atguigu.ssm.mapper.EmployeeMapper;
import com.atguigu.ssm.pojo.Employee;
import com.atguigu.ssm.service.EmployeeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yu yang
 * @date 2022/8/24 -21:18
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public List<Employee> getAllEmp() {
        return employeeMapper.getAllEmp();
    }

    @Override
    public PageInfo<Employee> getEmpPage(Integer pageNum,String keyword) {
        //开启分页功能
        PageHelper.startPage(pageNum,5);
        //查询所有的员工信息
        List<Employee> list = null;
        if (keyword==null||keyword.length()==0){
            list = employeeMapper.getAllEmp();
        }else {
            list = employeeMapper.getEmpByMohu(keyword);
        }
        //获取分页相关数据
        PageInfo<Employee> pageInfo = new PageInfo<>(list,5);
        return pageInfo;
    }

    @Override
    public void addEmp(Employee employee) {
        employeeMapper.addEmp(employee);
    }

    @Override
    public Employee getEmpById(Integer empId) {
        Employee emp = employeeMapper.getEmpById(empId);
        return emp;
    }

    @Override
    public void update(Employee employee) {
        employeeMapper.update(employee);
    }

    @Override
    public void deleteEmp(Integer empId) {
        employeeMapper.deleteEmp(empId);
    }
}
