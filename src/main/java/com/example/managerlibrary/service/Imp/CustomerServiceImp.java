package com.example.managerlibrary.service.Imp;

import com.example.managerlibrary.entity.Customer;
import com.example.managerlibrary.repository.CustomerRepo;
import com.example.managerlibrary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {
   @Autowired
    private CustomerRepo customerRepo;


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepo.save(customer);
    }

    @Override
    public Page<Customer> findAllCustomers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Customer> customers = customerRepo.findAll(pageable);
        return customers;

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Optional<Customer> customerOptional =  customerRepo.findById(customer.getCustomerId());
        if (customerOptional.isPresent()) {
            customerOptional.get().setName(customer.getName());
            customerOptional.get().setPhone(customer.getPhone());
            customerRepo.save(customerOptional.get());
        }
        return customerRepo.save(customer);
    }



    @Override
    public Optional<Customer> findCustomerById(Integer id) {
        return customerRepo.findById(id);
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerRepo.deleteById(id);

    }

    public List<Customer> searchCustomerByLastName(String name) {
        Specification<Customer> specification = (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("name"), name);
        return customerRepo.findAll(specification);
    }




}
