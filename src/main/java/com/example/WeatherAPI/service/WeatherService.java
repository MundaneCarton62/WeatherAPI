package com.example.WeatherAPI.service;

import com.example.WeatherAPI.exception.WeatherApiException;
import com.example.WeatherAPI.model.ExternalWeatherResponse;
import com.example.WeatherAPI.model.WeatherResponse;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;

@Service
public class WeatherService {

    private final WeatherClient client;

    public WeatherService(WeatherClient client) {
        this.client = client;
    }

    @Cacheable(value = "weather", key = "#city")
    public WeatherResponse weather(String city){

        try {

            ExternalWeatherResponse ext = client.fetchWeather(city);

            WeatherResponse response = new WeatherResponse();

            response.setTemperature(ext.getDays().get(0).getTemp());
            response.setDescription(ext.getDays().get(0).getDescription());

            response.setFullAddress(ext.getResolvedAddress());
            response.setAddress(ext.getAddress());

            response.setTimezone(ext.getTimezone());

            return response;

        } catch (HttpClientErrorException e) {
            throw new WeatherApiException("Invalid city");

        } catch (HttpServerErrorException e) {
            throw new WeatherApiException("Weather service unavailable");

        }  catch (ResourceAccessException e) {
            throw new WeatherApiException("Cannot reach weather service");

        }
    }
}
