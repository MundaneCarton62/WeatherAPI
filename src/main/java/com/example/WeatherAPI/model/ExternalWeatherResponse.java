package com.example.WeatherAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExternalWeatherResponse {

    private List<Days> days;

    private String resolvedAddress;
    private String address;

    private String timezone;

    @SuppressWarnings("unused")
    public ExternalWeatherResponse() {
    }

    public ExternalWeatherResponse(List<Days> days, String resolvedAddress, String address, String timezone) {
        this.days = days;
        this.resolvedAddress = resolvedAddress;
        this.address = address;
        this.timezone = timezone;
    }

    public List<Days> getDays() {
        return days;
    }

    @SuppressWarnings("unused")
    public void setDays(List<Days> days) {
        this.days = days;
    }


    public String getResolvedAddress() {
        return resolvedAddress;
    }

    @SuppressWarnings("unused")
    public void setResolvedAddress(String resolvedAddress) {
        this.resolvedAddress = resolvedAddress;
    }

    public String getAddress() {
        return address;
    }

    @SuppressWarnings("unused")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getTimezone() {
        return timezone;
    }

    @SuppressWarnings("unused")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
