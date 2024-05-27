package com.example.managerlibrary.service;

import com.example.managerlibrary.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public interface CustomerService {
    public Customer addCustomer(Customer customer);
    public List<Customer> findAllCustomers();
    public Customer updateCustomer(Customer customer);
    public Optional<Customer> findCustomerById(Integer id);
    public void deleteCustomer(Integer id);

}
