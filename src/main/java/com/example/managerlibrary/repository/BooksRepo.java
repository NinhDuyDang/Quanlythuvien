package com.example.managerlibrary.repository;

import com.example.managerlibrary.entity.Books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface BooksRepo extends JpaRepository<Books, Integer> {
    Optional<Books> findByBookId(Integer bookId);
}
