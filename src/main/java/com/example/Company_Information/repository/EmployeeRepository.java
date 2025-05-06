package com.example.Company_Information.repository;

import com.example.Company_Information.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Optional<Employee> findByEmpNameAndEmpAge(String empName, int empAge);
}
