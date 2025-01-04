package com.example.weatherapp.controller;

import com.example.weatherapp.dto.WeatherResponse;
import com.example.weatherapp.service.WeatherService;
import com.example.weatherapp.service.GeocodingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;
    private final GeocodingService geocodingService;

    public WeatherController(WeatherService weatherService, GeocodingService geocodingService) {
        this.weatherService = weatherService;
        this.geocodingService = geocodingService;
    }

    @GetMapping("/weather")
    public WeatherResponse.CurrentWeather getWeather(@RequestParam String city) {
        double[] coordinates = geocodingService.getCoordinates(city);
        if (coordinates != null) {
            double lat = coordinates[0];
            double lon = coordinates[1];
            return weatherService.getWeather(lat, lon);
        }
        return null;  // Or handle invalid city cases
    }
}