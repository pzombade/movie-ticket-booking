package com.publicissapient.movieticketbooking.repository;

import com.publicissapient.movieticketbooking.entity.Screen;
import com.publicissapient.movieticketbooking.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ScreenRepository extends JpaRepository<Screen, UUID> {
    public Screen findByName(String name); //name
    public Screen findByScreenId(UUID uuid); //name
}
