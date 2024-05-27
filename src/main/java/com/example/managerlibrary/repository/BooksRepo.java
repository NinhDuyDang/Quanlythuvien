package com.example.managerlibrary.repository;

import com.example.managerlibrary.entity.Books;
import com.example.managerlibrary.entity.Customer;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.Optional;
@Repository

public interface BooksRepo extends JpaRepository<Books, Integer> {
    Optional<Books> findByBookId(Integer bookId);
}
