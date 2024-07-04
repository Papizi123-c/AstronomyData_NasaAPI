package com.example.microserviceb.repository;

import com.example.microserviceb.model.AstronomyData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronomyDataRepository extends JpaRepository<AstronomyData, Long> {
}
