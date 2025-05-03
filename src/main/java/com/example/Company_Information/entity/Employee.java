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
    private int emp_id;
    private String emp_name;
    private int emp_Age;

    @JoinColumn(name = "fk_add_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;



}
