package com.raimbek.spring.springboot.springboot_rest.controller;


import com.raimbek.spring.springboot.springboot_rest.entity.Employee;
import com.raimbek.spring.springboot.springboot_rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> employeeList = employeeService.getListEmployees();
        return employeeList;
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        Employee employee = employeeService.getEmployeeById(id);
        return employee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
         employeeService.addEmployee(employee);
         return employee;
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id){
        Employee employee =employeeService.getEmployeeById(id);//1 получить баотника


        employeeService.deleteEmployee(id); //2 удалить его
        return  "Employee with id "+ id+ " was deleted"; // 3 dsdtcnb byajhvfwb.
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody  Employee employee){

        employeeService.addEmployee(employee);
        return employee;
    }


}
