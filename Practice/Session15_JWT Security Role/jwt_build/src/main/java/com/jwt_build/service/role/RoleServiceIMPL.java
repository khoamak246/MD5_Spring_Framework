package com.jwt_build.service.role;

import com.jwt_build.model.Role;
import com.jwt_build.model.RoleName;
import com.jwt_build.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class RoleServiceIMPL implements IRoleService{
    @Autowired
    IRoleRepository repository;
    @Override
    public Optional<Role> findByName(RoleName name) {
        return repository.findByName(name);
    }
}
