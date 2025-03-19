package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.coustomexception.UserNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import org.springframework.http.ResponseEntity;


import java.util.List;
import java.util.Optional;

public interface EmployeeService {
  List<Employee> getEmployee();
  ResponseEntity<Employee> create(EmployeeDTO employeeDTO);
  Optional<Employee> getByID(Long id)throws UserNotFoundException;
  String update(Long id,EmployeeDTO employeesDTO);
  void deleteById(Long id);
}
