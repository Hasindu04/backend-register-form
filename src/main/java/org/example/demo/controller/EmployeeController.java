package org.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.example.demo.entity.EmployeeEntity;
import org.example.demo.model.Employee;
import org.example.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/save-employee")
    public EmployeeEntity saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/get-all-employees")
    public List<Employee> getAllEmployees(){
        return employeeService.gellAllEmployees();
    }

    @GetMapping("/get-employee-by-name/{empName}")
    public List<Employee> getEmployeeByName(@PathVariable String empName){
        return employeeService.getEmployeeByName(empName);
    }

    @PostMapping("/update-employee")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete-by-id")
    public Map<String, String> deleteByID(@RequestParam Integer id){
        return Collections.singletonMap("DELETE", employeeService.deleteById(id));
    }
}
