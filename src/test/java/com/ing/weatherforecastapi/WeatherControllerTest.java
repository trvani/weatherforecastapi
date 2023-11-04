package com.ing.weatherforecastapi;

import com.ing.weatherforecastapi.controller.WeatherController;
import com.ing.weatherforecastapi.dto.WeatherForecastDTO;
import com.ing.weatherforecastapi.service.WeatherService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(WeatherController.class)
public class WeatherControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private WeatherService weatherService;

	@Test
	public void getForecast_ShouldReturnWeatherForecast() throws Exception {
		// Given
		WeatherForecastDTO mockDto = new WeatherForecastDTO();
		mockDto.setMaxTemperature(20.0);
		mockDto.setFeelsLikeTemperature(18.0);
		mockDto.setHumidity(55.0);
		given(weatherService.getWeather("TestCity")).willReturn(mockDto);

		// When & Then
		mockMvc.perform(get("/weather/forecast")
						.param("city", "TestCity"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.maxTemperature").value(20.0))
				.andExpect(jsonPath("$.feelsLikeTemperature").value(18.0))
				.andExpect(jsonPath("$.humidity").value(55.0));
	}
}
