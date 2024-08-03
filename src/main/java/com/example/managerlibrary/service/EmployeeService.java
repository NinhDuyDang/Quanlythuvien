package com.example.managerlibrary.service;

import com.example.managerlibrary.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface EmployeeService {
     Employee addEmployee(Employee employee);
     List<Employee> findAllEmployees();
     Employee updateEmployee(Employee employee);
     Optional<Employee> findEmployeeById(Integer id);
     void deleteEmployee(Integer id);
}
