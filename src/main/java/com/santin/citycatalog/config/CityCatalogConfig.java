package com.santin.citycatalog.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.santin.citycatalog.repository.CityRepository;
import com.santin.citycatalog.service.CityService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.santin")
public class CityCatalogConfig {

    @Bean
    public CityRepository cityRepository() {
        return new CityRepository();
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public CityService cityService(final CityRepository cityRepository,
                                   final ObjectMapper objectMapper) {
        return new CityService(cityRepository, objectMapper);
    }

}
