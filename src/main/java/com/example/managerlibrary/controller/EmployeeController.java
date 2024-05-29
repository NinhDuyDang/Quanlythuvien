package com.example.managerlibrary.controller;
import com.example.managerlibrary.entity.Employee;
import com.example.managerlibrary.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/allEmployee")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("AllEmployeeById/{Id}")
    public Optional<Employee> getAllEmployee(@PathVariable("id") int id) {
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        return employee;
    }

    @PostMapping("add/employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.addEmployee(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PutMapping("update/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id")int id, @RequestBody Employee employee) {
        Optional<Employee> emp = employeeService.findEmployeeById(id);
        if (emp.isPresent()) {
            emp.get().setName(employee.getName());
            emp.get().setAge(employee.getAge());
            emp.get().setStartedDate();
            emp.get().setType(employee.getType());
            Employee updateEmployee = employeeService.updateEmployee(emp.get());
            return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("delete/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
