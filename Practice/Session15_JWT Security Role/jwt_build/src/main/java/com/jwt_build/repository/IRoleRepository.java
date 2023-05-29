package com.jwt_build.repository;


import com.jwt_build.model.Role;
import com.jwt_build.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);
}

