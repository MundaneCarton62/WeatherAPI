package com.example.WeatherAPI;


import com.example.WeatherAPI.controller.WeatherController;
import com.example.WeatherAPI.model.WeatherResponse;
import com.example.WeatherAPI.service.WeatherService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherControllerTest {

    @Mock
    WeatherService service;         //fake service

    @InjectMocks
    WeatherController controller;   //real controller, fake service inside

    @Test
    void shouldReturnWeatherFromService(){

        //fake service returns a WeatherResponse
        when(service.weather("Guadalajara, Jal")).thenReturn(
                new WeatherResponse("Guadalajara, Jal, México", "Guadalajara, Jal", 17.0, "Cloudy skies throughout the day.", "America/Mexico_City"));

        // We call the service
        String city = "Guadalajara, Jal";
        WeatherResponse response = controller.weather(city);


        // THEN: service must return the Weather Response
        assertNotNull(response);
        assertEquals("Guadalajara, Jal, México", response.getFullAddress());
        assertEquals(17.0, response.getTemperature());

        // And call the correct method
        verify(service).weather(city);
    }
}
