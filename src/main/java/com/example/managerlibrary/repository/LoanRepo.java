package com.example.managerlibrary.repository;

import com.example.managerlibrary.entity.Loans;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LoanRepo extends JpaRepository<Loans, Integer> {
}
