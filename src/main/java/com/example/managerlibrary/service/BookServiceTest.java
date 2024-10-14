package com.example.managerlibrary.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class BookServiceTest {

    private final String API_URL = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=a6edeff8aff54d8195eda6c66781f8ab";
    private final String API_KEY = "a6edeff8aff54d8195eda6c66781f8ab"; // Thay bằng API key của bạn

    public Map<String, Object> searchBooks(String query) {
        RestTemplate restTemplate = new RestTemplate();

        // Xây dựng URL với query và API key
        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("q", query)
                .queryParam("key", API_KEY)
                .toUriString();

        // Gửi request GET và nhận phản hồi dưới dạng Map (JSON)
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);

        return response;
    }

}
