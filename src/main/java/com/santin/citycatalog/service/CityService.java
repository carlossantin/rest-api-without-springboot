package com.santin.citycatalog.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.santin.citycatalog.dto.CityDto;
import com.santin.citycatalog.entity.City;
import com.santin.citycatalog.repository.CityRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public CityDto updateCity(CityDto cityDto) {
        City city = cityRepository.findById(cityDto.getId());
        city.setName(cityDto.getName());

        cityRepository.update(city);
        return cityDto;
    }

    public List<CityDto> getAllCities() {
        List<City> allCities = cityRepository.findAll();
        return objectMapper.convertValue(allCities, new TypeReference<List<CityDto>>(){});
    }

    public CityDto getCityById(Long id) {
        City city = cityRepository.findById(id);
        if (city != null) {
            return objectMapper.convertValue(city, CityDto.class);
        }
        throw new RuntimeException(String.format("There isn't a city having ID = %s", id));
    }
    public void removeCity(Long id) {
        cityRepository.delete(id);
    }
}
