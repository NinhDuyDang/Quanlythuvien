package com.example.managerlibrary.service;

import com.example.managerlibrary.entity.Books;
import com.example.managerlibrary.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BooksSevice {
     Books addBook(Books book);
     List<Books> findAllBooks();
     Books updateBooks(Books book);
     Optional<Books> findBookById(Integer id);
     void deleteBookById(Integer id);

}
