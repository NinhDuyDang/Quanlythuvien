package com.example.managerlibrary.repository;

import com.example.managerlibrary.entity.Cancel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CancelRepository extends JpaRepository<Cancel, Integer> {
}
