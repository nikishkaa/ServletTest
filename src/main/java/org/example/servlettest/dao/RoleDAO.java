package org.example.servlettest.dao;

import org.example.servlettest.model.Role;
import org.example.servlettest.model.User;

import java.sql.SQLException;

public interface RoleDAO {
    Role findById(int id) throws SQLException;

    Role findByUser(User user);


}
