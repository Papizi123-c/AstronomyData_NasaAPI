package com.example.microserviceb.client;

import com.example.microserviceb.model.NasaApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "nasaApi", url = "https://api.nasa.gov")
public interface NasaApiClient {
    @GetMapping("/planetary/apod?api_key=iBWfp9wDfZiOLDTAxxzkOaHlXW9dhLF4ymddiaRv")
    ResponseEntity<NasaApiResponse> getAstronomyPictureOfDay();
}
