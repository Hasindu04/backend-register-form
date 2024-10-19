package org.example.demo.service;

import org.example.demo.entity.EmployeeEntity;
import org.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    EmployeeEntity saveEmployee(Employee employee);

    List<Employee> gellAllEmployees();

    Employee updateEmployee(Employee employee);

    List<Employee> getEmployeeByName(String empName);

    String deleteById(Integer id);
}
