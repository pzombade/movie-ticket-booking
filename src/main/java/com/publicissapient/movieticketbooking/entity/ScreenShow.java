package com.publicissapient.movieticketbooking.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.security.core.Transient;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class ScreenShow {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID screenShowId;

    private UUID screenId;

    private UUID showId;

//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime showDateTime; //  = LocalDateTime.now()
}

