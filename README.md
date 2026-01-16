# Weather API — v1.0 (MC62)


A simple **REST API** built with Spring Boot that acts as a wrapper around the
**Visual Crossing Weather API**.

It allows users to request weather data by city name and receive a clean,
simplified response with the most useful information.

This project runs on **Java 8+** and is part of a collection of small projects made for fun and learning.
https://roadmap.sh/projects/weather-api-wrapper-service

---

## Features

- Fetch real-time weather data by city name
- Clean and simplified API response
- Built-in **rate limiting** to protect the API
- Fully tested with unit and integration tests

Returned data includes:
- **Full Address** (city, state, country when available)
- **Address**
- **Temperature** (°C)
- **Weather description**
- **Timezone**

---

## API Endpoint
GET /weather?city={cityName}

### Example
GET /weather?city=Guadalajara, Jal

### Example Response
```json
{
  "fullAddress": "Guadalajara, Jal, México",
  "address": "Guadalajara, Jal",
  "temperature": 27.0,
  "description": "Cloudy with a chance of meatballs.",
  "timezone": "America/Mexico_City"
} 
```

---
## Rate Limiting

Implemented using Bucket4j

Limits the number of requests per client

Returns HTTP 429 – Too Many Requests when exceeded

---

## Tech Stack

Java 17

Spring Boot

Spring MVC

Thymeleaf

Maven

JUnit 5

Mockito

MockMvc

Bucket4j

Redis