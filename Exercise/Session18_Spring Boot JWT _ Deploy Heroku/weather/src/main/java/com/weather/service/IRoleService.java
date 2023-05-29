package com.weather.service;

import com.weather.model.Role;
import com.weather.model.RoleName;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName role);
}
