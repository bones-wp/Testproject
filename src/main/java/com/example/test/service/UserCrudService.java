package com.example.test.service;

import com.example.test.entity.User;

import java.util.Optional;

public interface UserCrudService {

    User save(User user);

    Optional<User> find(String id);

    Optional<User> findByUsername(String username);
}
