package com.example.managerlibrary.service;

import com.example.managerlibrary.dto.CountryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
@FeignClient(name = "country-client", url = "https://api.first.org/data/v1")
public interface CountryClient {
    @GetMapping("/countries")
    CountryResponse getAllCountries();
}
