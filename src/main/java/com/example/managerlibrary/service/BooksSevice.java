package com.example.managerlibrary.service;

import com.example.managerlibrary.entity.Books;
import com.example.managerlibrary.entity.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BooksSevice {
    public Books addBook(Books book);
    public List<Books> findAllBooks();
    public Books updateBooks(Books book);
    public Optional<Books> findBookById(Integer id);
    public void deleteBookById(Integer id);

}
