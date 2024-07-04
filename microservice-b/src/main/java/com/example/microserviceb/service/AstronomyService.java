package com.example.microserviceb.service;

import com.example.microserviceb.client.NasaApiClient;
import com.example.microserviceb.model.AstronomyData;
import com.example.microserviceb.model.NasaApiResponse;
import com.example.microserviceb.repository.AstronomyDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AstronomyService {

    @Autowired
    private NasaApiClient nasaApiClient;

    @Autowired
    private AstronomyDataRepository repository;

    public AstronomyData getAstronomyData() {
        NasaApiResponse response = nasaApiClient.getAstronomyPictureOfDay().getBody();
        AstronomyData data = new AstronomyData();
        data.setTitle(response.getTitle());
        data.setUrl(response.getUrl());
        data.setExplanation(response.getExplanation());
        repository.save(data);
        return data;
    }
}
