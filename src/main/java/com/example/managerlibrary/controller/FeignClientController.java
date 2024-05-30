package com.example.managerlibrary.controller;

import com.example.managerlibrary.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class FeignClientController {

    private final CountryService countryService;

    @Autowired
    public FeignClientController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public ResponseEntity<String> getAllCountries() {
        String countries = countryService.getAllCountries();
        return new ResponseEntity<>(countries, HttpStatus.OK);
    }
}
