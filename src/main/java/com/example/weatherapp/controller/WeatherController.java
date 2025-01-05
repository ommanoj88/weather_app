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

    // Constructor injection for services
    public WeatherController(WeatherService weatherService, GeocodingService geocodingService) {
        this.weatherService = weatherService;
        this.geocodingService = geocodingService;
    }

    @GetMapping("/weather")
    public WeatherResponse getWeather(@RequestParam String city) {
        double[] coordinates = geocodingService.getCoordinates(city);  // Get latitude and longitude for the city

        if (coordinates != null) {
            double lat = coordinates[0];
            double lon = coordinates[1];

            // Get the weather response based on coordinates (latitude and longitude)
            WeatherResponse weatherResponse = weatherService.getWeather(lat, lon);

            // Return the temperature and its description
            return weatherResponse;
        }

        return null;  // Handle invalid city or coordinates
    }
}