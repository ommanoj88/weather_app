package com.example.weatherapp.service;

import com.example.weatherapp.dto.WeatherResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherResponse getWeather(double lat, double lon) {
        // API endpoint for fetching weather data
        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + lat + "&longitude=" + lon + "&current_weather=true";

        // Get the API response
        ResponseEntity<WeatherResponse> response = restTemplate.exchange(url, HttpMethod.GET, null, WeatherResponse.class);

        WeatherResponse weatherResponse = response.getBody();

        // Check if the temperature is valid and assign weather description based on temperature
        if (weatherResponse != null && weatherResponse.getCurrent_weather() != null) {
            double temperature = weatherResponse.getCurrent_weather().getTemperature();

            // Assign weather description based on temperature
            String description = getWeatherDescriptionBasedOnTemperature(temperature);
            weatherResponse.getCurrent_weather().setWeatherDescription(description);
        }

        return weatherResponse;
    }

    private String getWeatherDescriptionBasedOnTemperature(double temperature) {
        if (temperature < 0) {
            return "Very Cold";
        } else if (temperature >= 0 && temperature < 10) {
            return "Cold";
        } else if (temperature >= 10 && temperature < 20) {
            return "Warm";
        } else if (temperature >= 20 && temperature < 30) {
            return "Hot";
        } else {
            return "Very Hot";
        }
    }
}