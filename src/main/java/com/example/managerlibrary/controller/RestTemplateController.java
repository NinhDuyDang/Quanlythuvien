package com.example.managerlibrary.controller;

import com.example.managerlibrary.dto.CountryResponse;
import com.example.managerlibrary.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("https://newsapi.org/v2/everything?q=Apple&from=2024-10-12&sortBy=popularity&apiKey=API_KEY")
public class RestTemplateController {
  @Autowired
  private CountryService countryService;

    @GetMapping("/list")
    public CountryResponse getAllCountries() {
        return countryService.getAllCountriesRestTemplate();
    }



}
