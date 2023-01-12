package com.publicissapient.movieticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class Screen {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID screenId;

    private UUID theaterId;

    private String name;
}
