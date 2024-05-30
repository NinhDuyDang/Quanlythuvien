package com.example.managerlibrary.controller;

import com.example.managerlibrary.dto.CountryResponse;
import com.example.managerlibrary.entity.CountryEntity;
import com.example.managerlibrary.service.CountryClient;
import com.example.managerlibrary.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/countries")
public class FeignClientController {
    private final CountryService countryService;

    @Autowired
    public FeignClientController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/all")
    public ResponseEntity<CountryResponse> getAllCountries() {
        CountryResponse countryResponse = countryService.getAllCountries();
        return new ResponseEntity<>(countryResponse, HttpStatus.OK);
    }


}
