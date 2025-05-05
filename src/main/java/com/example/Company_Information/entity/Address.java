package com.example.Company_Information.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


//@Entity
@Embeddable
@Getter
@Setter
//@Table(name = "address")
public class Address {



//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private int id;

        private String street;
        private String city;
        private String postalCode;
        private String addressType;


//        @OneToOne(mappedBy = "address")
//        private Employee employee;
}
