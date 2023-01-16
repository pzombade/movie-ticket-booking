package com.publicissapient.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "user_entity")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
