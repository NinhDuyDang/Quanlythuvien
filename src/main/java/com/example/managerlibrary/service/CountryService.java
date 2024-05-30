package com.example.managerlibrary.service;

import com.example.managerlibrary.dto.CountryResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CountryService {
    CountryResponse getAllCountries();
}
