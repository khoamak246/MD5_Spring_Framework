package com.jwt_springboot.service;


import com.jwt_springboot.model.Role;
import com.jwt_springboot.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
