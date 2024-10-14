package com.example.managerlibrary.controller;

import com.example.managerlibrary.service.BookServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
@RestController
public class BookControllerTest {


    @Autowired
    private BookServiceTest bookServiceTest;

    @GetMapping("/search-books")
    public ResponseEntity<List<Map<String, Object>>> searchBooks(@RequestParam(value = "query", required = false, defaultValue = "") String query) {

            List<Map<String, Object>> result = bookServiceTest.searchBooks(query);
            return ResponseEntity.ok(result);

    }
}
