package com.example.test.service;

import com.example.test.entity.User;

import java.util.Optional;

public interface UserAuthenticationService {

    /**
     * Logs in with the given {@code username} and {@code password}.
     * @return an {@link Optional} of a user when login succeeds
     */
    Optional<String> login(String username, String password);

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     */
    Optional<User> findByToken(String token);

    /**
     * Logs out the given input {@code user}.
     * @param user the user to logout
     */
    void logout(User user);
}
