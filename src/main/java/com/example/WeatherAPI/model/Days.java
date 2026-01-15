package com.example.WeatherAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Days {

    private double temp;
    private String description;

    public double getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }
}