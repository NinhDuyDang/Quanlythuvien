package com.example.managerlibrary.controller;
import com.example.managerlibrary.entity.Customer;
import com.example.managerlibrary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("api/v1/customer")

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public ResponseEntity<List<Customer>> getAllCustomers(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        Page<Customer> list =  customerService.findAllCustomers(page, size );
        return new ResponseEntity<>(list.getContent(), HttpStatus.OK);
    }

    @GetMapping("list/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id) {
        Optional<Customer> customer = customerService.findCustomerById(id);
        return customer.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        Customer newCustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/search")
    public List<Customer> searchCustomer(@RequestParam String name) {
        return customerService.searchCustomerByLastName(name);
    }


}
