package com.jwt_springboot.service.impl;

import com.jwt_springboot.model.Role;
import com.jwt_springboot.model.RoleName;
import com.jwt_springboot.repository.IRoleRepository;
import com.jwt_springboot.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
