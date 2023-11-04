package com.ing.weatherforecastapi.model;

import java.util.List;

public class WeatherForecast {
    private List<Forecast> list;

    public List<Forecast> getList() {
        return list;
    }

    public void setList(List<Forecast> list) {
        this.list = list;
    }

    public static class Forecast {
        private Main main;

        public Main getMain() {
            return main;
        }

        public void setMain(Main main) {
            this.main = main;
        }

        public static class Main {
            private double temp_max;
            private Double feels_like;
            private Double humidity;






            public Double getTemp_max() {
                return temp_max;
            }


            public Double getFeels_like() {
                return feels_like;
            }


            public Double getHumidity() {
                return humidity;
            }

            // Setters
            public void setMaxTemperature(Double maxTemperature) {
                this.temp_max = maxTemperature;
            }

            public void setFeels_like(Double feels_like) {
                this.feels_like = feels_like;
            }

            public void setHumidity(Double humidity) {
                this.humidity = humidity;
            }
        }
    }
}
