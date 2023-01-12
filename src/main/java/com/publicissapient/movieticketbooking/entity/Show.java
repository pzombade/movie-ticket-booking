package com.publicissapient.movieticketbooking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.Transient;

import java.util.UUID;

@Entity
@Data
public class Show {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID showId;

    private String title;

    private String language;

    @Transient
    public enum Genere { SCIFI, COMEDY, THRILLER, HORROR, DRAMA };

    private Genere genere;
}
