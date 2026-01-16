package com.example.WeatherAPI.model;

import java.io.Serializable;

public class WeatherResponse implements Serializable{

    private String fullAddress;
    private String address;
    private double temperature;
    private String description;
    private String timezone;


    @SuppressWarnings("unused")
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @SuppressWarnings("unused")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SuppressWarnings("unused")
    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    @SuppressWarnings("unused")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @SuppressWarnings("unused")
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}