//package com.example.managerlibrary.controller;
//
//import com.example.managerlibrary.entity.Article;
//import com.example.managerlibrary.service.BookServiceTest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.List;
//@Controller
//@RestController
//public class BookControllerTest {
////    @Autowired
////    private BookServiceTest bookServiceTest;
////
////    @GetMapping("/searchBooks")
////    public List<Article> searchBooks(@RequestParam(value = "query", required = false, defaultValue = "") String query) {
////         return  bookServiceTest.searchBooks(query);
////
////    }
package com.example.managerlibrary.controller;
import com.example.managerlibrary.entity.Article;
import com.example.managerlibrary.service.BookServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BookControllerTest {

    @Autowired
    private BookServiceTest bookServiceTest;

    @GetMapping("/search")
    public String search(@RequestParam(value = "query", required = false, defaultValue = "") String query, Model model) {
        List<Article> articles = bookServiceTest.searchBooks(query);
        model.addAttribute("articles", articles);

        return "searchForm";
    }

    @GetMapping("/searchForm")
    public String showSearchForm(Model model) {
        model.addAttribute("query", new String());
        return "searchForm";
    }
}
