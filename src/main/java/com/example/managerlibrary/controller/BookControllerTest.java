package com.example.managerlibrary.controller;

import com.example.managerlibrary.service.BookServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
public class BookControllerTest {


    @Autowired
    private BookServiceTest bookService;

    // Endpoint để tìm kiếm sách với query parameter 'query'
    @GetMapping("/api/books/test")
    public Map<String, Object> searchBooks(@RequestParam(value = "query", required = false, defaultValue = "") String query) {
        // Gọi service để lấy dữ liệu từ NewsAPI
        return bookService.searchBooks(query);
    }
}
