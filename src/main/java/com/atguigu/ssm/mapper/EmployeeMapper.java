package com.atguigu.ssm.mapper;

import com.atguigu.ssm.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yu yang
 * @date 2022/8/24 -21:32
 */
@Mapper
public interface EmployeeMapper {
    //查询所有的员工信息
    List<Employee> getAllEmp();
    //添加员工信息
    void addEmp(Employee employee);
    //根据id查询员工信息
    Employee getEmpById(@Param("id") Integer empId);
    //修改员工信息
    void update(Employee employee);
    //根据id删除员工信息
    void deleteEmp(@Param("id") Integer empId);
    //查询所有员工（模糊查询）
    List<Employee> getEmpByMohu(@Param("mohu") String keyword);
}
