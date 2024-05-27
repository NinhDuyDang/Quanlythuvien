package com.example.managerlibrary.repository;

import com.example.managerlibrary.entity.Customer;
import com.example.managerlibrary.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {
   Optional<Customer> findByCustomerId(Integer employeeId);


}
