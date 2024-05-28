package com.example.managerlibrary.repository;

import com.example.managerlibrary.entity.Loans;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface LoanRepo extends JpaRepository<Loans, Integer> {
     List<Loans> findAll();
}
