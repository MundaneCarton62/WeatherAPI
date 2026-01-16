package com.example.WeatherAPI.service;

import com.example.WeatherAPI.model.ExternalWeatherResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherClient {

    private final RestTemplate restTemplate;
    private final String apiKey;

    public WeatherClient(RestTemplate restTemplate,
                         @Value("${weather.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiKey = apiKey;
    }


    public ExternalWeatherResponse fetchWeather(String city){
        String url = "https://weather.visualcrossing.com/VisualCrossingWebServices/rest/services/timeline/"
                + city
                + "?unitGroup=metric"
                + "&key=" + apiKey
                + "&contentType=json";

        return restTemplate.getForObject(url, ExternalWeatherResponse.class);
    }
}
