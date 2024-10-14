package com.example.managerlibrary.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceTest {

    private final String API_URL = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=a6edeff8aff54d8195eda6c66781f8ab";
    private final String API_KEY = "a6edeff8aff54d8195eda6c66781f8ab";

    public List<Map<String, Object>> searchBooks(String query) {
        RestTemplate restTemplate = new RestTemplate();
        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("q", query)
                .queryParam("key", API_KEY)
                .toUriString();
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        // Chuyển Map thành JSONObject
        JSONObject jsonResponse = new JSONObject(response);
        List<Map<String, Object>> articlesList = new ArrayList<>();
        if (jsonResponse.has("articles")) {
            JSONArray articles = jsonResponse.getJSONArray("articles");
            // Lặp qua từng phần tử trong mảng JSON và chuyển nó thành Map
            for (int i = 0; i < articles.length(); i++) {
                JSONObject article = articles.getJSONObject(i);
                Map<String, Object> articleMap = new HashMap<>();
                // Duyệt qua từng khóa trong JSONObject và thêm vào Map
                for (String key : article.keySet()) {
                    articleMap.put(key, article.get(key));
                }

                articlesList.add(articleMap);
            }
        }
        return articlesList;
    }
}
