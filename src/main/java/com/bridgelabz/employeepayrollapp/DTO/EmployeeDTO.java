package com.bridgelabz.employeepayrollapp.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @NotBlank(message = "Name should not be empty or null")
    private String name;
    @Min(value = 10000, message = "Salary must be at least 10,000")
    private double salary;
    @NotBlank(message = "Profile picture cannot be empty")
    private String profilePic;

    @NotEmpty(message = "Gender cannot be empty")
    @Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
    private String gender;

    @NotEmpty(message = "Departments cannot be empty")
    private List<String> departments;

    @NotEmpty(message = "Start date cannot be empty")
    @JsonFormat(pattern = "dd MMM yyyy")
    private String startDate;

    @NotBlank(message = "Note cannot be empty")
    private String note;
}
