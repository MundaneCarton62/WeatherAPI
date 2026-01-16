package com.example.WeatherAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@SuppressWarnings("unused")
public class RestTemplateConfig {

    @Bean
    @SuppressWarnings("unused")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
