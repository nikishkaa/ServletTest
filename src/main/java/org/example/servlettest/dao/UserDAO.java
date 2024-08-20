package org.example.servlettest.dao;

import org.example.servlettest.model.User;

import java.util.Set;

public interface UserDAO {
    User findUserByEmail(String email);

    boolean createUser(User user);

    boolean activate(User user);

    Set<User> findAll();

}
