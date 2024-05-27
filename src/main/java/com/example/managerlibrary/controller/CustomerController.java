package com.example.managerlibrary.controller;

import com.example.managerlibrary.entity.Customer;
import com.example.managerlibrary.entity.Employee;
import com.example.managerlibrary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @GetMapping("/AllCustomer")
    public ResponseEntity<List<Customer>> getAllCustomer() {
        List<Customer> customerList = customerService.findAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);

    }
    @GetMapping("CustomerById/{Id}")

    public Optional<Customer> getCustomerById(@PathVariable("id") int Id) {
        Optional<Customer> customer = customerService.findCustomerById(Id);
        return customer;
    }
    @PostMapping("add/customer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("update/customer/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id")int id, @RequestBody Employee employee) {

        Optional<Customer> customer = customerService.findCustomerById(id);
        if (customer.isPresent()) {
            customer.get().setName(employee.getName());
            customer.get().setPhone();

            customerService.updateCustomer(customer.get());
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("delete/customer/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
