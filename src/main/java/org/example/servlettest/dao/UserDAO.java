package org.example.servlettest.dao;

import org.example.servlettest.model.User;

public interface UserDAO {
    User findUserByEmail(String email);

    boolean createUser(User user);


}
