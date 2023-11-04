package com.ing.weatherforecastapi.service;

import com.ing.weatherforecastapi.dto.WeatherForecastDTO;
import com.ing.weatherforecastapi.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${openweather.api.url}")
    private String apiUrl;

    @Value("${openweather.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;

    @Autowired
    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public WeatherForecastDTO getWeather(String city) {
        String url = String.format("%s?q=%s&appid=%s&units=metric", apiUrl, city, apiKey);
        WeatherForecast response = restTemplate.getForObject(url, WeatherForecast.class);

        // Convert model to DTO for the first forecast day
        WeatherForecastDTO dto = new WeatherForecastDTO();
        dto.setMaxTemperature(response.getList().get(0).getMain().getTemp_max());
        dto.setFeelsLikeTemperature(response.getList().get(0).getMain().getFeels_like());
        dto.setHumidity(response.getList().get(0).getMain().getHumidity());

        return dto;
    }
}
