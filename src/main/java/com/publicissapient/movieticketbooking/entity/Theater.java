package com.publicissapient.movieticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Theater {
    @Id
    @GeneratedValue(generator = "UUID")
    private UUID theaterId;

    private String name;
    private String hashedPassword;
    private String emailId;
    private int phone;
    private String zip;
}
