package com.example.microserviceb.controller;

import com.example.microserviceb.model.AstronomyData;
import com.example.microserviceb.service.AstronomyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/astronomy")
public class AstronomyController {

    @Autowired
    private AstronomyService astronomyService;

    @GetMapping
    public ResponseEntity<AstronomyData> getAstronomyData() {
        return ResponseEntity.ok(astronomyService.getAstronomyData());
    }
}
