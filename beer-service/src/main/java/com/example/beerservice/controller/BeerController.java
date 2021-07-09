package com.example.beerservice.controller;

import com.example.beerservice.entity.Beer;
import com.example.beerservice.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class BeerController {

    private final BeerRepository repository;

    @Autowired
    public BeerController(BeerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/")
    public String getBeerHome() {
        return "Welcome to Ingram Brewery!";
    }

    @GetMapping("/all-beers")
    public List<Beer> getBeers() {
        return repository.findAll();
    }

    @GetMapping("/{name}")
    public Beer getBeerByName(@PathVariable("name") String name) {
        return repository.findAllByBeername(name);
    }

    @PostMapping("/create")
    public void saveCourse(@RequestBody Beer course) {
        repository.save(course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable("id") BigInteger id) {
        repository.deleteById(id);
    }
}

