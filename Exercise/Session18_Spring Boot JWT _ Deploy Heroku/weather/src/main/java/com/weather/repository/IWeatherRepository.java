package com.weather.repository;

import com.weather.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IWeatherRepository extends JpaRepository<Weather, Long> {
    Optional<Weather> findByLocation(String name);
}
