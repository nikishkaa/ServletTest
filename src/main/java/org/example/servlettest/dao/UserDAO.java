package org.example.servlettest.dao;

import org.example.servlettest.model.User;

import java.sql.SQLException;
import java.util.Set;

public interface UserDAO {
    User findUserByEmail(String email) throws SQLException;

    boolean createUser(User user);

    boolean activate(User user);

    Set<User> findAll();

}
