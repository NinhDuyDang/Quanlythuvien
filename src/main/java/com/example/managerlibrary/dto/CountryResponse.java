package com.example.managerlibrary.dto;

import com.example.managerlibrary.entity.CountryEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;
@Getter
@Setter
public class CountryResponse {


    private String status;
    @JsonProperty("status-code")
    private Integer statusCode;
    private String version;
    private String access;
    private Map<String, CountryEntity> data;

}
