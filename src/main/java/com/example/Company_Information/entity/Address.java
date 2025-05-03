package com.example.Company_Information.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "address")
public class Address {



        @Id
        @GeneratedValue
        @Column(name = "add_id")
        private int addressId;
        private String city;
        private String addressType;

        @OneToOne(mappedBy = "address")
        private Employee employee;
}
