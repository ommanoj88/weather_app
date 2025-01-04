package com.example.weatherapp.service;

import com.example.weatherapp.dto.GeocodingResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

@Service
public class GeocodingService {

    private static final String GEOCODE_API_URL = "https://nominatim.openstreetmap.org/search?city={city}&format=json";

    private final RestTemplate restTemplate;

    public GeocodingService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double[] getCoordinates(String city) {
        String url = GEOCODE_API_URL.replace("{city}", city);

        // Expect an array of GeocodingResponse objects
        ResponseEntity<GeocodingResponse[]> response = restTemplate.getForEntity(url, GeocodingResponse[].class);

        if (response.getBody() != null && response.getBody().length > 0) {
            GeocodingResponse result = response.getBody()[0];
            return new double[]{result.getLat(), result.getLon()};
        }
        return null;  // Return null if no results are found
    }
}