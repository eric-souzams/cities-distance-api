package com.project.citiesapi.countries.controller;

import com.project.citiesapi.countries.entities.Country;
import com.project.citiesapi.countries.repositories.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/countries")
public class CountryController {

    private CountryRepository countryRepository;

    public CountryController(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @GetMapping
    public Page<Country> getAll(Pageable page) {
        return countryRepository.findAll(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id) {
        Optional<Country> result = countryRepository.findById(id);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result.get());
    }

}
