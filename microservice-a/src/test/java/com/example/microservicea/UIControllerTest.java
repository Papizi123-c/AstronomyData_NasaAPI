package com.example.microservicea.controller;

import com.example.microservicea.client.MicroserviceBClient;
import com.example.microservicea.model.AstronomyData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UIControllerTest {

    @Mock
    private MicroserviceBClient microserviceBClient;

    @InjectMocks
    private SwaggerController SwaggerController;

    @Test
    public void testGetAstronomyData() {
        AstronomyData mockData = new AstronomyData();
        mockData.setTitle("Astronomy Picture of the Day");
        mockData.setUrl("http://example.com/image.jpg");
        mockData.setExplanation("Explanation of the picture.");

        when(microserviceBClient.getAstronomyData()).thenReturn(ResponseEntity.ok(mockData));

        ResponseEntity<AstronomyData> response = SwaggerController.getAstronomyData();

        assertEquals("Astronomy Picture of the Day", response.getBody().getTitle());
        assertEquals("http://example.com/image.jpg", response.getBody().getUrl());
        assertEquals("Explanation of the picture.", response.getBody().getExplanation());
    }
}
