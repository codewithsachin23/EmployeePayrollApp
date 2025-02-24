package com.bridgelabz.employeepayrollapp.model;


import jakarta.persistence.*;


@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double salary;

}
