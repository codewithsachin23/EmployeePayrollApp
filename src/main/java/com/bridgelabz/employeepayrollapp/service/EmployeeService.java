package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

public interface EmployeeService {
  List<Employee> getEmployee();
  String create(EmployeeDTO employeeDTO);
  Optional<Employee> getByID(Long id);
  String update(Long id,EmployeeDTO employeesDTO);
  void deleteById(Long id);
}
