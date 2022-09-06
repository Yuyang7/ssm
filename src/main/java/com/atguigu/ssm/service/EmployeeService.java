package com.atguigu.ssm.service;

import com.atguigu.ssm.pojo.Employee;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author yu yang
 * @date 2022/8/24 -21:18
 */
public interface EmployeeService {
    //查询所有员工信息
    List<Employee> getAllEmp();
    //获取员工的分页信息
    PageInfo<Employee> getEmpPage(Integer pageNum,String keyword);
    //添加员工信息
    void addEmp(Employee employee);
    //根据id查询员工信息
    Employee getEmpById(Integer empId);
    //修改员工信息
    void update(Employee employee);
    //根据id删除员工信息
    void deleteEmp(Integer empId);
}
