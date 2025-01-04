package com.example.weatherapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

    private CurrentWeather current_weather;

    public CurrentWeather getCurrent_weather() {
        return current_weather;
    }

    public void setCurrent_weather(CurrentWeather current_weather) {
        this.current_weather = current_weather;
    }

    // Inner class to handle current weather details
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CurrentWeather {
        private double temperature;
        private int humidity;
        private String weatherDescription;  // You can map this manually

        // Getters and Setters
        public double getTemperature() {
            return temperature;
        }

        public void setTemperature(double temperature) {
            this.temperature = temperature;
        }

        public int getHumidity() {
            return humidity;
        }

        public void setHumidity(int humidity) {
            this.humidity = humidity;
        }

        public String getWeatherDescription() {
            return weatherDescription;
        }

        public void setWeatherDescription(String weatherDescription) {
            this.weatherDescription = weatherDescription;
        }
    }
}