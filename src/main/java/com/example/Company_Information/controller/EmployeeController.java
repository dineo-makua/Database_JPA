package com.example.Company_Information.controller;

import com.example.Company_Information.entity.Employee;
import com.example.Company_Information.repository.EmployeeRepository;
import com.example.Company_Information.service.EmployeeDataLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeDataLoader employeeDataLoader;

    @PostMapping("/loadJsonEmployees")
    public ResponseEntity<String> loadJsonEmployees() {
        String result = employeeDataLoader.loadEmployeesFromJson();
        return ResponseEntity.ok(result);
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/saveEmployees")
    public ResponseEntity<String> saveEmployees(@RequestBody List<Employee> empData) {
        employeeRepository.saveAll(empData);
        return ResponseEntity.ok("Data saved");
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    // GET by emp_name and emp_Age
    @GetMapping("/getEmployeeByDetails")
    public ResponseEntity<Employee> getEmployeeByDetails(@RequestParam String empName,
                                                         @RequestParam int empAge) {
        Optional<Employee> emp = employeeRepository.findByEmpNameAndEmpAge(empName, empAge);
        return emp.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }




    // UPDATE by emp_name and emp_Age


    // DELETE by emp_name and emp_Age
    @DeleteMapping("/deleteEmployeeByDetails")
    public ResponseEntity<String> deleteEmployeeByDetails(@RequestParam String empName,
                                                          @RequestParam int empAge) {
        Optional<Employee> emp = employeeRepository.findByEmpNameAndEmpAge(empName, empAge);
        if (emp.isPresent()) {
            employeeRepository.delete(emp.get());
            return ResponseEntity.ok("Employee deleted");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/deleteAllEmployees")
    public ResponseEntity<String> deleteAllEmployees(@RequestParam String password) {
        // Check if the password is correct
        String correctPassword = "Cutiboy@21";
        if (correctPassword.equals(password)) {
            employeeRepository.deleteAll();
            return ResponseEntity.ok("All employees deleted");
        } else {
            return ResponseEntity.status(403).body("Forbidden: Incorrect password");
        }
    }
}
