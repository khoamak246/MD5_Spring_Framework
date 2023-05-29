package com.signin_outsecurity.repository;

import com.signin_outsecurity.model.Role;
import com.signin_outsecurity.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}
