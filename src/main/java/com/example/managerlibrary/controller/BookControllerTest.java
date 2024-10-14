package com.example.managerlibrary.controller;

import com.example.managerlibrary.entity.Article;
import com.example.managerlibrary.service.BookServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
public class BookControllerTest {
    @Autowired
    private BookServiceTest bookServiceTest;

    @GetMapping("/searchBooks")
    public List<Article> searchBooks(@RequestParam(value = "query", required = false, defaultValue = "") String query) {
        return bookServiceTest.searchBooks(query);
    }
}
