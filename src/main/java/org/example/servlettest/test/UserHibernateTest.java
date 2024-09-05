package org.example.servlettest.test;

import org.example.servlettest.dao.impl.UserDao;
import org.example.servlettest.db.JPAService;
import org.example.servlettest.db.config.JpaConfiguration;
import org.example.servlettest.model.User;

import java.util.List;

public class UserHibernateTest {

    public static void main(String[] args) {
        JpaConfiguration configuration = new JpaConfiguration();
        configuration.setUserName("root");
        configuration.setPassword("");
        configuration.setDriver("com.mysql.jdbc.Driver");
        configuration.setUrl("jdbc:mysql://localhost:3308/j1023_db");
        configuration.setPersistentUnit(User.class.getName());
        JPAService.initialize();


        UserDao userDao = new UserDao();



//        System.out.println(userDao.findAll("email like 'gu.nikita.777@gmail.com'"));


    }
}
