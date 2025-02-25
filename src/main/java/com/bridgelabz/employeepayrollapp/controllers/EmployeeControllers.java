package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/EmployeeApp")
public class EmployeeControllers {
    @Autowired
    EmployeeService employeeService;
    @GetMapping
    public List<Employee> getEmployee(){

        return employeeService.getEmployee();
    }
    @PostMapping
    public String create(@RequestBody @Valid EmployeeDTO employeeDTO){
       return employeeService.create(employeeDTO);
    }
    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable long id){
        return employeeService.getByID(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable long id,@RequestBody @Valid EmployeeDTO employeeDTO){
       return employeeService.update(id,employeeDTO);

    }

    @DeleteMapping("/{id}")

    public void deleteByID(@PathVariable long id){
        employeeService.deleteById(id);
    }

}
