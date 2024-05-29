package com.example.managerlibrary.service;

import com.example.managerlibrary.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.Optional;
@Service
public interface CustomerService {

    Customer addCustomer(Customer customer);
    Page<Customer> findAllCustomers(int page, int size);
    Customer updateCustomer(Customer customer);
    Optional<Customer> findCustomerById(Integer id);
    void deleteCustomer(Integer id);


}
