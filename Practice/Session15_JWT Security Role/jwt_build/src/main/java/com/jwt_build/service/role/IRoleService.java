package com.jwt_build.service.role;

import com.jwt_build.model.Role;
import com.jwt_build.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
