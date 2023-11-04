package com.ing.weatherforecastapi.controller;

import com.ing.weatherforecastapi.dto.WeatherForecastDTO;
import com.ing.weatherforecastapi.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/forecast")
    public WeatherForecastDTO getForecast(@RequestParam String city) {
        return weatherService.getWeather(city);
    }
}

