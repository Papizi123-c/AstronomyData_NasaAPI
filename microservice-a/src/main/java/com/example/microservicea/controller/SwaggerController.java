package com.example.microservicea.controller;

import com.example.microservicea.client.MicroserviceBClient;
import com.example.microservicea.model.AstronomyData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ui")
public class SwaggerController {

    @Autowired
    private MicroserviceBClient microserviceBClient;

    @GetMapping("/astronomy")
    public ResponseEntity<AstronomyData> getAstronomyData() {
        return microserviceBClient.getAstronomyData();
    }
}
