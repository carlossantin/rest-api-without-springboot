package com.santin.citycatalog.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.santin.citycatalog.controller.input.NewCityInput;
import com.santin.citycatalog.dto.CityDto;
import com.santin.citycatalog.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityCatalogController {

    @Autowired
    private CityService cityService;
    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping
    public ResponseEntity<CityDto> addCity(@RequestBody NewCityInput city) {
        CityDto cityDto = cityService.addCity(objectMapper.convertValue(city, CityDto.class));
        return ResponseEntity.ok(cityDto);
    }

    @PatchMapping
    public ResponseEntity<CityDto> updateCity(@RequestBody CityDto city) {
        CityDto cityDto = cityService.updateCity(city);
        return ResponseEntity.ok(cityDto);
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CityDto> getCity(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cityService.getCityById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCity(@PathVariable("id") Long id) {
        cityService.removeCity(id);
        return ResponseEntity.ok(String.format("City with ID %s removed", id));
    }
}