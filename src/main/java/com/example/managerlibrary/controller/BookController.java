package com.example.managerlibrary.controller;
import com.example.managerlibrary.entity.Books;
import com.example.managerlibrary.service.BooksSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/book")

public class BookController {
    @Autowired
    private BooksSevice booksSevice;
    @GetMapping("/list")
    public ResponseEntity<List<Books>> getAllBook() {
        List<Books> booksList = booksSevice.findAllBooks();
        return new ResponseEntity<>(booksList, HttpStatus.OK);
    }

    @GetMapping("list/{id}")

    public Optional<Books> getBookById(@PathVariable("id") int Id) {
        Optional<Books> books = booksSevice.findBookById(Id);
        return books;
    }

    @PostMapping("/add")
    public ResponseEntity<Books> addbook(@RequestBody Books book) {
        Books books = booksSevice.addBook(book);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable("id") int id, @RequestBody Books book) {

        return new ResponseEntity<>(booksSevice.updateBooks(book), HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable("id") int id) {
        booksSevice.deleteBookById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
