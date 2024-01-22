package com.employee.EmployeeApplication.service;


import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
       List<Employee> employeeList = new ArrayList<>(Arrays.asList(
                new Employee(1, "First Employee", "Washington"),
                new Employee(2, "Second Employee", "New York")
        ));

       @Autowired
       EmployeeRepository employeeRepository;
       public List<Employee> getAllEmployees(){
//        return employeeList;
           return employeeRepository.findAll(); //returns list of all employees
    }
    public Employee getAnEmployee(int id){
//           return employeeList.stream().filter(e -> (
//                   e.getEmployeeId() == id)).findFirst().get();
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }
//Getting the employee object from the class
    public void createEmployee(Employee employee){
           ArrayList<Address> addressArrayList = new ArrayList<>();

           for (Address address : employee.getAddresses()) {
             addressArrayList.add((new Address(address.getLine1(),
                     address.getLine2(), address.getZipcode(), address.getCity(), address.getState(),
                     address.getCountry(), employee)));
           }
           employee.setAddresses(addressArrayList);

        employeeRepository.save(employee);//saves to jpa repo
    }
    //update employee record
    public void updateEmployee(Employee employee){

        employeeRepository.save(employee);
    }

    //delete an employee
    public void deleteEmployee(int id) {

        employeeRepository.delete(employeeRepository.getReferenceById(id));
    }
}
