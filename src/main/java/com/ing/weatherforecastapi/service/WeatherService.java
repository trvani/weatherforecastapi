package com.ing.weatherforecastapi.service;

import com.ing.weatherforecastapi.dto.WeatherForecastDTO;
import com.ing.weatherforecastapi.exception.WeatherServiceException;
import com.ing.weatherforecastapi.model.WeatherForecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
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
        try
        {
            ResponseEntity<WeatherForecast> response = restTemplate.getForEntity(url, WeatherForecast.class);

            if(response.getStatusCode().is2xxSuccessful() && response.getBody() != null)
            {
                WeatherForecast weatherForecast = response.getBody();
                // Convert model to DTO for the first forecast day
                WeatherForecastDTO dto = new WeatherForecastDTO();
                dto.setMaxTemperature(weatherForecast.getList().get(0).getMain().getTemp_max());
                dto.setFeelsLikeTemperature(weatherForecast.getList().get(0).getMain().getFeels_like());
                dto.setHumidity(weatherForecast.getList().get(0).getMain().getHumidity());
                return dto;

            }
            else
            {
                throw new WeatherServiceException("Failed to retrieve weather data");
            }
        }catch (RestClientException e) {
            // Log the exception details
            throw new WeatherServiceException("Error calling external weather service", e);
        }


    }
}
