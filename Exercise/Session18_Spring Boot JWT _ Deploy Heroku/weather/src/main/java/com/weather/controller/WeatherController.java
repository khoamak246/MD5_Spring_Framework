package com.weather.controller;


import com.weather.dto.response.ResponseMessage;
import com.weather.model.Weather;
import com.weather.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {

    @Autowired
    private IWeatherService weatherService;

    @GetMapping("/{username}/{password}/{location}")
    public ResponseEntity<Weather> findByName(@PathVariable("location") String location) {
        Optional<Weather> weather = weatherService.findByLocation(location);
        return weather.map(value -> ResponseEntity.status(HttpStatus.OK).body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null));
    }
}
