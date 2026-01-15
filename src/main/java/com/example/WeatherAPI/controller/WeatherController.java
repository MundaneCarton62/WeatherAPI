package com.example.WeatherAPI.controller;

import com.example.WeatherAPI.model.WeatherResponse;
import com.example.WeatherAPI.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService service;

    @GetMapping("/{city}")
    @SuppressWarnings("unused")
    public WeatherResponse WeatherResponse (@PathVariable String city){

        return service.weather(city);
    }
}
