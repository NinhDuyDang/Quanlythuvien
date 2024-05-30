package com.example.managerlibrary;
import com.example.managerlibrary.dto.LoansResponse;
import com.example.managerlibrary.entity.Loans;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableFeignClients
public class ManagerLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManagerLibraryApplication.class, args);
    }
@Configuration

public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        // Tạo object và cấu hình
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper;

        }

    }

}
