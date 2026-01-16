package com.example.WeatherAPI;

import com.example.WeatherAPI.exception.WeatherApiException;
import com.example.WeatherAPI.model.Days;
import com.example.WeatherAPI.model.ExternalWeatherResponse;
import com.example.WeatherAPI.model.WeatherResponse;
import com.example.WeatherAPI.service.WeatherClient;
import com.example.WeatherAPI.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceTest {

    @Mock
    WeatherClient client;         //fake service

    @InjectMocks
    WeatherService service;   //real controller, fake service inside

    @Test
    void shouldReturnWeatherFromClient(){

        List<Days> fakeDays = List.of(
                new Days(27.0, "Cloudy with a chance of meatballs"));

        ExternalWeatherResponse fakeResponse =
                new ExternalWeatherResponse(
                        fakeDays, "Guadalajara, Jal, México", "Guadalajara, Jal", "America/Mexico_City");


        //fake service returns a WeatherResponse
        when(client.fetchWeather("Guadalajara, Jal")).
                thenReturn(fakeResponse);

        // We call the client
        String city = "Guadalajara, Jal";
        WeatherResponse response = service.weather(city);


        // THEN: client must return the Weather Response
        assertNotNull(response);
        assertEquals("Guadalajara, Jal, México", response.getFullAddress());
        assertEquals("Cloudy with a chance of meatballs", response.getDescription());
        assertEquals(27.0, response.getTemperature());

        // And call the correct method
        verify(client).fetchWeather(city);
    }

    @Test
    void shouldThrowExceptionWhenCityIsInvalid() {

        String city = "garbage-city";

        when(client.fetchWeather(city))
                .thenThrow(HttpClientErrorException.BadRequest.create(
                        HttpStatusCode.valueOf(400), "Bad Request", null, null, null));

        assertThrows(WeatherApiException.class,() -> service.weather(city));

        verify(client).fetchWeather(city);
    }

    @Test
    void shouldThrowExceptionWhenApiIsDown() {

        String city = "Guadalajara, Jal";

        when(client.fetchWeather(city))
                .thenThrow(new ResourceAccessException("API unreachable"));

        assertThrows(WeatherApiException.class, () -> service.weather(city));

        verify(client).fetchWeather(city);
    }

}