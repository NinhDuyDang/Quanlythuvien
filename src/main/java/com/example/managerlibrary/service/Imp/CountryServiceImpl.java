package com.example.managerlibrary.service.Imp;

import com.example.managerlibrary.dto.CountryResponse;
import com.example.managerlibrary.service.CountryClient;
import com.example.managerlibrary.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryClient countryClient;

    @Autowired
    public CountryServiceImpl(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    @Override
    public CountryResponse getAllCountries() {
        return countryClient.getAllCountries();
       }
    }

