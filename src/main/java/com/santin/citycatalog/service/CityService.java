package com.santin.citycatalog.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santin.citycatalog.dto.CityDto;
import com.santin.citycatalog.entity.City;
import com.santin.citycatalog.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    private final CityRepository cityRepository;
    private final ObjectMapper objectMapper;

    public CityService(final CityRepository cityRepository,
                       final ObjectMapper objectMapper) {
        this.cityRepository = cityRepository;
        this.objectMapper = objectMapper;
    }

    public CityDto addCity(CityDto cityDto) {
        City city = objectMapper.convertValue(cityDto, City.class);
        city = cityRepository.add(city);
        return objectMapper.convertValue(city, CityDto.class);
    }

    public List<CityDto> getAllCities() {
        List<City> allCities = cityRepository.findAll();
        return objectMapper.convertValue(allCities, new TypeReference<List<CityDto>>(){});
    }
}
