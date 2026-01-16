package com.example.WeatherAPI;

import com.example.WeatherAPI.model.Days;
import com.example.WeatherAPI.model.ExternalWeatherResponse;
import com.example.WeatherAPI.service.WeatherClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationMockMvcTest {

    @Autowired
    @SuppressWarnings("unused")
    private MockMvc mockMvc;

    @MockBean
    @SuppressWarnings("unused")
    private WeatherClient client;         //fake API

    @Test
    void shouldReturnWeather() throws Exception{

        List<Days> fakeDays = List.of(
                new Days(25.0, "Cloudy with a chance of meatballs"));

        ExternalWeatherResponse fakeResponse =
                new ExternalWeatherResponse(
                        fakeDays, "Guadalajara, Jal, México", "Guadalajara, Jal", "America/Mexico_City");


        //fake client returns a ExternalWeatherResponse
        when(client.fetchWeather("Guadalajara, Jal")).
                thenReturn(fakeResponse);


        mockMvc.perform(get("/weather/Guadalajara, Jal"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.fullAddress").value("Guadalajara, Jal, México"))
                .andExpect(jsonPath("$.temperature").value(25.0))
                .andExpect(jsonPath("$.description").value("Cloudy with a chance of meatballs"));

    }
}
