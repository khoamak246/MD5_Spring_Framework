package com.jwt_build.service.user;

import com.jwt_build.model.User;

import java.util.Optional;

public interface IUserService {
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
    Optional<User> findByUsername(String username);
    User save(User user);
}

