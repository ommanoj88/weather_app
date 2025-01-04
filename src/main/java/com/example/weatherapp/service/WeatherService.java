package com.example.weatherapp.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class WeatherService {

    private static final String API_URL = "https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&current_weather=true";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String getWeather(double lat, double lon) {
        String url = API_URL.replace("{lat}", String.valueOf(lat)).replace("{lon}", String.valueOf(lon));
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();  // Return raw JSON response
    }
}