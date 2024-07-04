package com.example.microserviceb.service;

import com.example.microserviceb.model.AstronomyData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AstronomyServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private AstronomyService astronomyService;

    @Test
    public void testGetAstronomyData() {
        AstronomyData mockData = new AstronomyData();
        mockData.setTitle("Astronomy Picture of the Day");
        mockData.setUrl("http://example.com/image.jpg");
        mockData.setExplanation("Explanation of the picture.");

        when(restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=YOUR_NASA_API_KEY", AstronomyData.class))
                .thenReturn(mockData);

        AstronomyData result = astronomyService.getAstronomyData();
        assertEquals("Astronomy Picture of the Day", result.getTitle());
        assertEquals("http://example.com/image.jpg", result.getUrl());
        assertEquals("Explanation of the picture.", result.getExplanation());
    }
}
