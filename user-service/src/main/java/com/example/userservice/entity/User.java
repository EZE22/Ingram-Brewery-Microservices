package com.example.userservice.entity;


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
public class User {
    @Id
    private BigInteger userid;
    private String username;
    private String email;
}
