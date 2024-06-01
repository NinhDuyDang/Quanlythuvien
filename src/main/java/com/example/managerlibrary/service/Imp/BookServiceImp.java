package com.example.managerlibrary.service.Imp;


import com.example.managerlibrary.entity.Books;
import com.example.managerlibrary.entity.Customer;
import com.example.managerlibrary.repository.BooksRepo;
import com.example.managerlibrary.service.BooksSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookServiceImp  implements BooksSevice {
@Autowired
private BooksRepo booksRepo;

    @Override
    public Books addBook(Books book) {
        return booksRepo.save(book);
    }

    @Override
    public List<Books> findAllBooks() {
        return booksRepo.findAll();
    }

    @Override
    public Books updateBooks(Books book) {
        Optional<Books> books = booksRepo.findByBookId(book.getBookId());
        if (books.isPresent()) {
            books.get().setTitle(book.getTitle());
            books.get().setAuthor(book.getAuthor());
            books.get().setCategory(book.getCategory());
            books.get().setQuantity(book.getQuantity());
            books.get().setPublisherDate(book.getPublisherDate());
            booksRepo.save(books.get());
        }
        return booksRepo.save(book);
    }

    @Override
    public Optional<Books> findBookById(Integer id) {
        return booksRepo.findById(id);
    }

    @Override
    public void deleteBookById(Integer id) {
        booksRepo.deleteById(id);
    }
}
