package com.example.managerlibrary.service;

import com.example.managerlibrary.entity.Article;
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
    public List<Article> searchBooks(String query) {
        RestTemplate restTemplate = new RestTemplate();
        String urlRequest = UriComponentsBuilder.fromHttpUrl(API_URL)
                .queryParam("q", query)
                .queryParam("key", API_KEY)
                .toUriString();
        Map<String, Object> response = restTemplate.getForObject(urlRequest, Map.class);
        // Convert Map to JSONObject
        JSONObject jsonResponse = new JSONObject(response);

        List<Article> articlesList = new ArrayList<>();
        if (jsonResponse.has("articles")) {
            JSONArray articles = jsonResponse.getJSONArray("articles");
            for (Object a : articles) {
                JSONObject article = (JSONObject) a;
                String author = article.optString("author", "Unknown");
                String title = article.optString("title", "No Title");
                String description = article.optString("description", "No Description");
                String url = article.optString("url", "");
                String urlToImage = article.optString("urlToImage", "");
                String publishedAt = article.optString("publishedAt", "Unknown Date");
                String content = article.optString("content", "No Content");
                Article object = new Article(author, title, description, url, urlToImage, publishedAt, content);
                articlesList.add(object);
            }
        }
        return articlesList;
       }
    }

