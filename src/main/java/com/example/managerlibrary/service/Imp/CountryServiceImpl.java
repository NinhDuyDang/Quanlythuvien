package com.example.managerlibrary.service.Imp;
import com.example.managerlibrary.dto.CountryResponse;
import com.example.managerlibrary.service.CountryClient;
import com.example.managerlibrary.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
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
       @Autowired
       private RestTemplate restTemplate;

      @Override
     public CountryResponse getAllCountriesRestTemplate() {
        String apiUrl = "https://api.first.org/data/v1/countries";
        ResponseEntity<CountryResponse> responseEntity = restTemplate.getForEntity(apiUrl, CountryResponse.class);

        if (responseEntity.getStatusCodeValue() == 200) {
            return responseEntity.getBody();
        } else {

            throw new RuntimeException("Lỗi khi gọi API: " + responseEntity.getStatusCodeValue());
        }
    }
}

