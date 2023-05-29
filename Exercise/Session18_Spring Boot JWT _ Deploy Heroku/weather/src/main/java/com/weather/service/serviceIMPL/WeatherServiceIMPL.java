package com.weather.service.serviceIMPL;

import com.weather.model.Weather;
import com.weather.repository.IWeatherRepository;
import com.weather.service.IWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceIMPL implements IWeatherService {

    @Autowired
    private IWeatherRepository weatherRepository;


    @Override
    public Optional<Weather> findByLocation(String location) {
        return weatherRepository.findByLocation(location);
    }
}
