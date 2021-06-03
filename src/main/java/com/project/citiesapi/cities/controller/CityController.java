package com.project.citiesapi.cities.controller;

import com.project.citiesapi.cities.entities.City;
import com.project.citiesapi.cities.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cities")
public class CityController {

    private CityRepository cityRepository;

    public CityController(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @GetMapping
    public Page<City> cities(Pageable page) {
        return cityRepository.findAll(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<City> getOne(@PathVariable Long id) {
        Optional<City> result = cityRepository.findById(id);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result.get());
    }

}
