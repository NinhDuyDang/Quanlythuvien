package com.example.managerlibrary.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CountryEntity {
    private String country;
    private String region;
    @Override
    public String toString() {
        return "CountryEntity [country=" + country + ", region=" + region + "]";
    }
}
