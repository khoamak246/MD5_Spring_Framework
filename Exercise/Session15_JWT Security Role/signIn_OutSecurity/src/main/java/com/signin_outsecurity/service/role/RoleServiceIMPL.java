package com.signin_outsecurity.service.role;

import com.signin_outsecurity.model.Role;
import com.signin_outsecurity.model.RoleName;
import com.signin_outsecurity.repository.IRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceIMPL implements IRoleService{
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
