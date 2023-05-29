package com.registerformvalidate.service;

import com.registerformvalidate.model.User;
import com.registerformvalidate.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceIMPL implements IUserService{

    @Autowired
    private IUserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
}
