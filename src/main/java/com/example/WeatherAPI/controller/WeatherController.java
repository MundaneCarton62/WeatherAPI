package com.example.WeatherAPI.controller;

import com.example.WeatherAPI.model.WeatherResponse;
import com.example.WeatherAPI.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/{city}")
    @SuppressWarnings("unused")
    public WeatherResponse weather(@PathVariable String city){

        return service.weather(city);
    }
}
