package com.example.beerservice.repository;

import com.example.beerservice.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BeerRepository extends JpaRepository<Beer, BigInteger> {
    Beer findAllByBeername(String beerName);
}
