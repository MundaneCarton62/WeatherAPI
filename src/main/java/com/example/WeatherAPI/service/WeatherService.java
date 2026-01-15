package com.example.WeatherAPI.service;

import com.example.WeatherAPI.model.ExternalWeatherResponse;
import com.example.WeatherAPI.model.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    private WeatherClient client;

    public WeatherResponse weather(String city){

        ExternalWeatherResponse ext = client.fetchWeather(city);

        WeatherResponse response = new WeatherResponse();

        response.setTemperature(ext.getDays().get(0).getTemp());
        response.setDescription(ext.getDays().get(0).getDescription());

        response.setFullAddress(ext.getResolvedAddress());
        response.setAddress(ext.getAddress());

        response.setTimezone(ext.getTimezone());

        return response;
    }
}
