package com.weather.service;

import com.weather.model.Weather;

import java.util.List;
import java.util.Optional;

public interface IWeatherService {
    Optional<Weather> findByLocation(String location);

}
