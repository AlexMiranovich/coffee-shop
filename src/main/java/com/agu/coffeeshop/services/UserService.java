package com.agu.coffeeshop.services;

import com.agu.coffeeshop.entities.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findById(String id);

    List<User> findAll();

    User update(User user);

    void delete(User user);
}
