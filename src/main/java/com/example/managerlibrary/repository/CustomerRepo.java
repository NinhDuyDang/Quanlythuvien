package com.example.managerlibrary.repository;
import com.example.managerlibrary.entity.Customer;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>, JpaSpecificationExecutor<Customer> {

}
