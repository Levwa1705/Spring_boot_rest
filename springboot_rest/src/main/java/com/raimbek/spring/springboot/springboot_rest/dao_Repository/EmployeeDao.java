package com.raimbek.spring.springboot.springboot_rest.dao_Repository;

import com.raimbek.spring.springboot.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> getListEmployees();
    public Employee getEmployeeById(int id);
    public void saveEmployee(Employee employee);
    public void deleteEmployee(int id);
}
