package com.agu.coffeeshop.services.impl;

import com.agu.coffeeshop.entities.User;
import com.agu.coffeeshop.entities.enums.UserStatus;
import com.agu.coffeeshop.repositories.UserRepository;
import com.agu.coffeeshop.services.UserService;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        user.setUserStatus(UserStatus.ACTIVE);
        user.setCreatedDate(Instant.now());
        return userRepository.save(user);
    }
}
