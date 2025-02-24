package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> getEmployee(){
        return employeeRepository.findAll();
    }

   public String create(EmployeeDTO employeeDTO){
        Employee employee=new Employee();
        employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(employee);
        return "Created new Employee";
    }
    public Optional<Employee> getByID(Long id){
        return employeeRepository.findById(id);
    }
    public String update(Long id,EmployeeDTO employeeDTO){
        Optional<Employee>optionalEmployee=employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            Employee e=new Employee();
            e.setName(employeeDTO.getName());
            e.setSalary(employeeDTO.getSalary());
            employeeRepository.save(e);
            return "updated";
        }
        return null;
    }
    public void deleteById(Long id){
        employeeRepository.deleteById(id);
    }

}
