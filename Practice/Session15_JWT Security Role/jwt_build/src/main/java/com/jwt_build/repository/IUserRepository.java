package com.jwt_build.repository;

import com.jwt_build.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface IUserRepository extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username); //Check username không trùng lặp
    Boolean existsByEmail(String email); //Check email không trùng lặp
    Optional<User> findByUsername(String username); //Tìm kiếm username có tồn tại trong DB không?
}

