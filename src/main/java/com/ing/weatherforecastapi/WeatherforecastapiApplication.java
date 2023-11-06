package com.ing.weatherforecastapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info =  @Info(title = "WeatherForecastAPI",version = "1.0.0"),
		servers = {@Server(url="http://localhost:8080") }
)
public class WeatherforecastapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherforecastapiApplication.class, args);
	}

}
