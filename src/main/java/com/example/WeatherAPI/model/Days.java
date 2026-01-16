package com.example.WeatherAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Days {

    private double temp;
    private String description;

    @SuppressWarnings("unused")
    public Days() {
    }

    public Days(double temp, String description) {
        this.temp = temp;
        this.description = description;
    }

    public double getTemp() {
        return temp;
    }

    public String getDescription() {
        return description;
    }
}