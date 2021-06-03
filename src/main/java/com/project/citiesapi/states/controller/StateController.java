package com.project.citiesapi.states.controller;

import com.project.citiesapi.states.entities.State;
import com.project.citiesapi.states.repository.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/states")
public class StateController {

    private StateRepository stateRepository;

    public StateController(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @GetMapping
    public Page<State> getAll(Pageable page) {
        return stateRepository.findAll(page);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<State> getOne(@PathVariable Long id) {
        Optional<State> result = stateRepository.findById(id);

        if (result.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(result.get());
    }

}
