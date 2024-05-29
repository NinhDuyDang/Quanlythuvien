package com.example.managerlibrary.repository;

import com.example.managerlibrary.entity.Customer;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{

//   Page<Customer> findAll( Pageable pageable );

}
