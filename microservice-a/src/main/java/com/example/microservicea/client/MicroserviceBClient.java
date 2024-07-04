package com.example.microservicea.client;

import com.example.microservicea.model.AstronomyData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "microservice-b", url = "http://localhost:8081")
public interface MicroserviceBClient {
    @GetMapping("/api/astronomy")
    ResponseEntity<AstronomyData> getAstronomyData();
}
