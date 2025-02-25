package com.bridgelabz.employeepayrollapp.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name should not be empty or null")
    private String name;
    @Min(value = 10000, message = "Salary must be at least 10,000")
    private double salary;
}
