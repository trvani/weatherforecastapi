package com.ing.weatherforecastapi.dto;

public class WeatherForecastDTO {
    private Double maxTemperature;
    private Double feelsLikeTemperature;
    private Double humidity;

    // Default constructor
    public WeatherForecastDTO() {}

    // Parameterized constructor
    public WeatherForecastDTO(Double maxTemperature, Double feelsLikeTemperature, Double humidity) {
        this.maxTemperature = maxTemperature;
        this.feelsLikeTemperature = feelsLikeTemperature;
        this.humidity = humidity;
    }

    // Getters
    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public Double getFeelsLikeTemperature() {
        return feelsLikeTemperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    // Setters
    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public void setFeelsLikeTemperature(Double feelsLikeTemperature) {
        this.feelsLikeTemperature = feelsLikeTemperature;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

}
