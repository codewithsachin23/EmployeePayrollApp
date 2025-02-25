package com.bridgelabz.employeepayrollapp.DTO;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "Name should not be empty or null")
    private String name;
    @Min(value = 10000, message = "Salary must be at least 10,000")
    private double salary;
}
