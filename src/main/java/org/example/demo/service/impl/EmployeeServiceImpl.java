package org.example.demo.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.example.demo.entity.EmployeeEntity;
import org.example.demo.exception.EmployeeAlreadyExistException;
import org.example.demo.model.Employee;
import org.example.demo.repository.EmployeeRepository;
import org.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ObjectMapper mapper;

    @Override
    public EmployeeEntity saveEmployee(Employee employee){
        Optional<EmployeeEntity> byEmail = employeeRepository.findByEmail(employee.getEmail());

        if (byEmail.isPresent()) {
            throw new EmployeeAlreadyExistException(
                    "employee already exist with the email: " + employee.getEmail());
        }

        EmployeeEntity employeeEntity = new EmployeeEntity();

        employeeEntity.setEmpName(employee.getEmpName());
        employeeEntity.setAge(employee.getAge());
        employeeEntity.setMobileNo(employee.getMobileNo());
        employeeEntity.setEmail(employee.getEmail());
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public List<Employee> gellAllEmployees() {
        Iterable<EmployeeEntity> entities = employeeRepository.findAll();

        List<Employee> employeeList = new ArrayList<>();
        entities.forEach(employeeEntity ->
            employeeList.add(mapper.convertValue(employeeEntity, Employee.class)));

        return employeeList;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        EmployeeEntity saved = employeeRepository.save(mapper.convertValue(employee, EmployeeEntity.class));
        return mapper.convertValue(saved, Employee.class);

    }

    @Override
    public List<Employee> getEmployeeByName(String empName) {
        Iterable<EmployeeEntity> allByEmpName = employeeRepository.findAllByEmpName(empName);

        List<Employee> employeeList = new ArrayList<>();
        allByEmpName.forEach(employeeEntity ->
                employeeList.add(mapper.convertValue(employeeEntity, Employee.class)));

        return employeeList;
    }

    @Override
    public String deleteById(Integer id) {
        if (employeeRepository.existsById(id)){
            employeeRepository.deleteById(id);

            return "SUCCESSFULLY DELETED";
        }
        return "DELETE FAIL";
    }
}
