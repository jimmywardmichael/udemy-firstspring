package com.employee.EmployeeApplication.repository;

import com.employee.EmployeeApplication.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    /*add crud
    getAllEmployees();
    getEmployeeId();
    updateEmployee(Employee employee);
    deleteEmployee(Employee employee);
    */

}
