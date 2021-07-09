package com.example.beerservice.repository;

import com.example.beerservice.entity.Beer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigInteger;

public interface BeerRepository extends JpaRepository<Beer, BigInteger> {

    Beer findAllByBeername(String beerName);
}
