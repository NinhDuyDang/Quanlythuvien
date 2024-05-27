package com.example.managerlibrary.service;

import com.example.managerlibrary.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface EmployeeService {
    public Employee addEmployee(Employee employee);
    public List<Employee> findAllEmployees();
    public Employee updateEmployee(Employee employee);
    public  Optional<Employee> findEmployeeById(Integer id);
    public void deleteEmployee(Integer id);


}
