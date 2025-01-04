package com.example.weatherapp.service;

import com.example.weatherapp.dto.WeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private static final String API_URL = "https://api.open-meteo.com/v1/forecast?latitude={lat}&longitude={lon}&current_weather=true";

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse.CurrentWeather getWeather(double lat, double lon) {
        String url = API_URL.replace("{lat}", String.valueOf(lat)).replace("{lon}", String.valueOf(lon));

        WeatherResponse weatherResponse = restTemplate.getForObject(url, WeatherResponse.class);
        if (weatherResponse != null) {
            return weatherResponse.getCurrent_weather();
        }
        return null;  // Return null if no weather data is available
    }
}