package com.example.Company_Information.controller;

import com.example.Company_Information.entity.Employee;
import com.example.Company_Information.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployees")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData) {
        employeeRepository.saveAll(empData);
        return ResponseEntity.ok("Data saved");
    }
}
