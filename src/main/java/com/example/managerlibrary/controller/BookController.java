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
@RequestMapping("/api")

public class BookController {
    @Autowired
    private BooksSevice booksSevice;
    @GetMapping("/AllBooks")
    public ResponseEntity<List<Books>> getAllBook() {
        List<Books> booksList = booksSevice.findAllBooks();
        return new ResponseEntity<>(booksList, HttpStatus.OK);
    }

    @GetMapping("AllBooksById/book/{Id}")

    public Optional<Books> getBookById(@PathVariable("id") int Id) {
        Optional<Books> books = booksSevice.findBookById(Id);
        return books;
    }

    @PostMapping("/add/book")
    public ResponseEntity<Books> addbook(@RequestBody Books book) {
        Books books = booksSevice.addBook(book);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @PutMapping("update/book/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable("id") int id, @RequestBody Books book) {
        Optional<Books> books = booksSevice.findBookById(id);
        if (books.isPresent()) {
            books.get().setTitle(book.getTitle());
            books.get().setAuthor(book.getAuthor());
            books.get().setCategory(book.getCategory());
            books.get().setQuantity(book.getQuantity());
            books.get().setPublisherDate(book.getPublisherDate());
            booksSevice.updateBooks(books.get());
        }
        return new ResponseEntity<>(books.get(), HttpStatus.OK);
    }
    @DeleteMapping("delete/book/{id}")
    public ResponseEntity<?> deleteBooks(@PathVariable("id") int id) {

        booksSevice.deleteBookById(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }
}
