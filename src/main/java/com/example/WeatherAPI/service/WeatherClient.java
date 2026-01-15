package com.example.WeatherAPI.service;

import com.example.WeatherAPI.model.ExternalWeatherResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Value;


@Service
public class WeatherClient {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${weather.api.key}")
    private String apiKey;


    public ExternalWeatherResponse fetchWeather(String city){
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                + city
                + "?unitGroup=metric"
                + "&key=" + apiKey
                + "&contentType=json";

        return restTemplate.getForObject(url, ExternalWeatherResponse.class);
    }
}
