package com.publicissapient.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "user_entity")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String userName;
    private String hashedPassword;
    private String emailId;
    private int phone;
    private String zip;

}
