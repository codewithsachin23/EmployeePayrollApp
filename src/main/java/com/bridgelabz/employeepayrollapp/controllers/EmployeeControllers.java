package com.bridgelabz.employeepayrollapp.controllers;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/EmployeeApp")
public class EmployeeControllers {
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }
    @PostMapping
    public String create(@RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(employee);
        return "employee created";
    }
    @GetMapping("/{id}")
    public Optional<Employee> findById(@PathVariable long id){
        return employeeRepository.findById(id);
    }

    @PutMapping("/{id}")
    public String update(@PathVariable long id,@RequestBody Employee employeeDTO){
        Optional<Employee> optionalEmployee=employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            Employee employee = new Employee();
            employee.setName(employeeDTO.getName());
            employee.setSalary(employeeDTO.getSalary());
            employeeRepository.save(employee);
        }
        return "Done";

    }

    @DeleteMapping("/{id}")

    public void deleteByID(@PathVariable long id){
        employeeRepository.deleteById(id);

    }

}
