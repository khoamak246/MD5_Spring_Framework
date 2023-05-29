package com.signin_outsecurity.service.role;

import com.signin_outsecurity.model.Role;
import com.signin_outsecurity.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
