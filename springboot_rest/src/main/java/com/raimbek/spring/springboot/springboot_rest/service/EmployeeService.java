package com.raimbek.spring.springboot.springboot_rest.service;

import com.raimbek.spring.springboot.springboot_rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getListEmployees();
    public Employee getEmployeeById(int id);
    public void addEmployee(Employee employee);
    public void deleteEmployee(int id);
}
