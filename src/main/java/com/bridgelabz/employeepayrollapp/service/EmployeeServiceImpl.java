package com.bridgelabz.employeepayrollapp.service;

import com.bridgelabz.employeepayrollapp.DTO.EmployeeDTO;
import com.bridgelabz.employeepayrollapp.coustomexception.UserNotFoundException;
import com.bridgelabz.employeepayrollapp.model.Employee;
import com.bridgelabz.employeepayrollapp.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    public List<Employee> getEmployee(){
        log.info("Display all Employee that have in App");
        return employeeRepository.findAll();
    }


   public String create(EmployeeDTO employeeDTO){
        Employee employee=new Employee();
       log.info("new Employee added");
       employee.setName(employeeDTO.getName());
        employee.setSalary(employeeDTO.getSalary());
        employeeRepository.save(employee);
       log.debug("Saved employee: {}", employee);

       return "Created new Employee";
    }
    public Optional<Employee> getByID(Long id)throws UserNotFoundException{
              log.info("Getting Employee Details based on ID");
              Optional<Employee> employee=  employeeRepository.findById(id);
              if (employee.isPresent()){
                  return employee;
              }else {
                  throw new UserNotFoundException("User not exit with id"+id);
              }
    }
    public String update(Long id,EmployeeDTO employeeDTO){
        Optional<Employee>optionalEmployee=employeeRepository.findById(id);
        if (optionalEmployee.isPresent()){
            Employee e=optionalEmployee.get();
            e.setName(employeeDTO.getName());
            e.setSalary(employeeDTO.getSalary());
            employeeRepository.save(e);
            log.info("Updated a existing Employee details");
            return "updated";
        }
        return null;
    }
    public void deleteById(Long id){
        log.info("Employee details deleted");
        employeeRepository.deleteById(id);
    }

}
