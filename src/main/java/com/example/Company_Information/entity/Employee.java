package com.example.Company_Information.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "employee_details")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "emp_name")
    private String empName;

    @Column(name = "emp_age")
    private int empAge;
    @JoinColumn(name = "fk_add_id")
    @Embedded
//    @OneToOne(fetch = FetchType.EAGER)
    private Address address;



}
