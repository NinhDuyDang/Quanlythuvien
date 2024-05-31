package com.example.managerlibrary.controller;

import com.example.managerlibrary.dto.CountryResponse;
import com.example.managerlibrary.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class RestTemplateController {
  @Autowired
  private CountryService countryService;

    @GetMapping("/countries")
    public CountryResponse getAllCountries() {
        return countryService.getAllCountriesRestTemplate();
    }
}
