package com.employee.EmployeeApplication.controller;

import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class EmployeeController {
@Autowired
    EmployeeService employeeService;
//Creates an instance of employeeService
    //Autowired checks employee if has dependency then injects it and creates instance
    @RequestMapping("/employees")
    public List<Employee> findAllEmployees(){

        return employeeService.getAllEmployees();
    }

    //Request mapping looks through all employees and will return which ever id you are looking for
    @RequestMapping("/employees/{id}")
    public Employee findAnEmployee(@PathVariable int id) {
        return employeeService.getAnEmployee(id);

        }
    }

