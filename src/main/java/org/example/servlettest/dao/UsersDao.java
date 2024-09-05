package org.example.servlettest.dao;

import org.example.servlettest.db.AbstractJpaDAO;
import org.example.servlettest.model.User;

import java.util.Objects;
import java.sql.Timestamp;

public class UsersDao extends AbstractJpaDAO<Integer, User> {

    public User findUserByEmail(String email) {

        return findFirst(String.format("email = '%s'", email));
    }


    public boolean activate(final String email) {
// set IS_ACTIVE = "Y" & UDT_TS - Current
        User user = findUserByEmail(email);
        user.setActive(true);
        user.setUpdatedTs(new Timestamp(System.currentTimeMillis()));


        return !Objects.isNull(update(user));
    }

}
