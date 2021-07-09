package com.example.beerservice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigInteger;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Beer {

    @Id
    private BigInteger beerid;
    private String beername;
    private String brewdate;
    private double alcoholpercent;
    private int quantityonhand;

}
