package com.ing.weatherforecastapi;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.ing.weatherforecastapi.dto.WeatherForecastDTO;
import com.ing.weatherforecastapi.model.WeatherForecast;
import com.ing.weatherforecastapi.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@SpringBootTest
public class WeatherIntegrationTest {

    @Autowired
    private WeatherService weatherService;

    @Test
    public void whenCalledWithAmsterdam_thenSuccess() {
        WeatherForecastDTO weatherForAmsterdam = weatherService.getWeather("Amsterdam");

        assertNotNull(weatherForAmsterdam);
    }
}