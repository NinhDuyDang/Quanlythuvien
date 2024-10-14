package com.example.managerlibrary.controller;
import com.example.managerlibrary.entity.Employee;
import com.example.managerlibrary.service.EmployeeService;
import com.example.managerlibrary.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired private MailService mailService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Optional<Employee> getAllEmployee(@PathVariable("id") int id) {
        Optional<Employee> employee = employeeService.findEmployeeById(id);
        return employee;
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee emp = employeeService.addEmployee(employee);
        mailService.sendEmail(employee);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id")int id, @RequestBody Employee employee) {

        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
