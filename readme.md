## Weather Forecast API Integration with Spring Boot
# Introduction
This project aims to integrate the OpenWeather API with a Spring Boot application to retrieve and display weather forecasts for a given city. The user can input a city name, and the application will provide maximum temperature, feels-like temperature, and humidity for the next 48 hours.

## Prerequisites
Java: Ensure you have Java 11 or higher installed.

Verify using the command: java -version
Maven: Ensure Maven is installed.

Verify using the command: mvn -v
IDE: Any IDE that supports Java and Spring Boot, like IntelliJ IDEA or Eclipse.

OpenWeather API Key: Register on OpenWeatherMap to get a free API key.

### Steps to Implement
1. Setting Up the Spring Boot Application
   Go to Spring Initializr.
   Choose Maven as the project type.
   Set the packaging to war and Java version to 11 or higher.
   Add dependencies: Spring Web and Rest Repositories.
   Download the project and extract it to your desired location.
   Open the project in your preferred IDE.
2. Application Configuration
   Open application.properties or application.yml.
   Add the OpenWeather API key: openweather.api.key=YOUR_API_KEY
3. Create DTOs and Models
   Create two packages: dto and model.
   Inside the dto package, create a class WeatherForecastDTO with fields:
   maxTemperature
   feelsLikeTemperature
   humidity
   Inside the model package, create classes that map to the JSON structure returned by OpenWeather API.
4. Create Service and Controller
   Create a service package. Inside this, create WeatherService that handles the integration with OpenWeather API.
   Create a controller package. Inside this, create WeatherController that exposes a REST API for clients to request weather forecasts.
5. Error Handling
   Create custom exceptions for any anticipated issues, like CityNotFoundException.
   Implement a global exception handler using @ControllerAdvice to handle exceptions and provide custom error messages.
6. Testing and Running the Application
   Create unit tests to validate the functionality of your service and controller methods.
   Use mvn clean install to build your project.
   Run your Spring Boot application. Navigate to the project directory in the terminal and use the command mvn spring-boot:run.
   Once the application is running, use tools like Postman or a browser to send requests and get weather forecasts.
   Conclusion
   This project provides a hands-on approach to integrating an external API with a Spring Boot application. The user can quickly get weather forecasts for any city by just providing the city name. Proper error handling ensures that users are guided correctly in case of any issues.

