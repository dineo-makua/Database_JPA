package com.example.Company_Information.service;


import com.example.Company_Information.entity.Employee;
import com.example.Company_Information.repository.EmployeeRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class EmployeeDataLoader {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String loadEmployeesFromJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = new ClassPathResource("model/employees_data.json").getInputStream();
            List<Employee> employees = mapper.readValue(inputStream, new TypeReference<List<Employee>>() {});
            employeeRepository.saveAll(employees);
            return "Employee data loaded successfully.";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to load employee data: " + e.getMessage();
        }
    }
}
