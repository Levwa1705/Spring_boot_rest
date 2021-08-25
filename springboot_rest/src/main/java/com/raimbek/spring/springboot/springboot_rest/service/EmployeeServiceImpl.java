package com.raimbek.spring.springboot.springboot_rest.service;

import com.raimbek.spring.springboot.springboot_rest.dao_Repository.EmployeeDao;
import com.raimbek.spring.springboot.springboot_rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class EmployeeServiceImpl  implements EmployeeService{
    @Autowired
    EmployeeDao employeeDao;



    @Override
    @Transactional
    public List<Employee> getListEmployees() {
        List employeeList = employeeDao.getListEmployees();
        return  employeeList;
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
      Employee employee = employeeDao.getEmployeeById(id);
      return employee;
    }

    @Override
    @Transactional
    public void addEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

}
