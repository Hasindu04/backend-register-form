package org.example.demo.repository;

import org.example.demo.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

    Iterable<EmployeeEntity> findAllByEmpName(String empName);

    Optional<EmployeeEntity> findByEmail(String email);
}
