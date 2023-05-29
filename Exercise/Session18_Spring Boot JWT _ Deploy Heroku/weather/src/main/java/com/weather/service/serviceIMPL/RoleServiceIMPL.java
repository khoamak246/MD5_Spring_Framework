package com.weather.service.serviceIMPL;

import com.weather.model.Role;
import com.weather.model.RoleName;
import com.weather.repository.IRoleRepository;
import com.weather.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceIMPL implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;
    @Override
    public Optional<Role> findByName(RoleName role) {
        return roleRepository.findByName(role);
    }
}
