package com.santin.citycatalog.controller;

import com.santin.citycatalog.dto.CityDto;
import com.santin.citycatalog.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/cities")
public class CityCatalogController {

    @Autowired
    private CityService cityService;

    @PostMapping
    public ResponseEntity<CityDto> addCity(@RequestBody CityDto city) {
        CityDto cityDto = cityService.addCity(city);
        return ResponseEntity.ok(cityDto);
    }

    @GetMapping
    public ResponseEntity<List<CityDto>> getAllCities() {
        return ResponseEntity.ok(cityService.getAllCities());
    }
}