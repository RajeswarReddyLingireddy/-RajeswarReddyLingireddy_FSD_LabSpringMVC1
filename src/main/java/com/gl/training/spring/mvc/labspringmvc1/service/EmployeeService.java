package com.gl.training.spring.mvc.labspringmvc1.service;

import com.gl.training.spring.mvc.labspringmvc1.entity.Employee;

import java.util.List;

public interface EmployeeService {
   List<Employee> getAllEmployees();
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);

    Employee updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);
}
