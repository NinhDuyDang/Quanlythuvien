package com.example.managerlibrary.service.Imp;

import com.example.managerlibrary.entity.Customer;
import com.example.managerlibrary.repository.CustomerRepo;
import com.example.managerlibrary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public Customer addCustomer(Customer customer) {
        return  customerRepo.save(customer);

    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerRepo.findAll();

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Optional<Customer> findCustomerById(Integer id) {
        return customerRepo.findByCustomerId(id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepo.deleteById(id);

    }
}
