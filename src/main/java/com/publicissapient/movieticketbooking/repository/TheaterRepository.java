package com.publicissapient.movieticketbooking.repository;

import com.publicissapient.movieticketbooking.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, UUID> {
    public Theater findByEmailId(String email); //emailId
}
