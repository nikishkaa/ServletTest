package org.example.servlettest.util;

import org.example.servlettest.NewLoginServlet;
import org.example.servlettest.entity.Cart;
import org.example.servlettest.entity.Employee;
import org.example.servlettest.entity.Item;
import org.example.servlettest.entity.Student;
import org.example.servlettest.model.Role;
import org.example.servlettest.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

public class HibernateAnnotationUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    /**
     * Utility class
     */
    private HibernateAnnotationUtil() {
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    private static SessionFactory buildSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(dbSettings())
                .build();

        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Role.class)

// Сюда включить классы!
                .buildMetadata();

        return metadata.buildSessionFactory();
    }

    private static Map<String, Object> dbSettings() {
        Map<String, Object> dbSettings = new HashMap<>();
        dbSettings.put(Environment.URL, "jdbc:mysql://localhost:3308/j1023_db");
        dbSettings.put(Environment.USER, "root");
        dbSettings.put(Environment.PASS, "");
        dbSettings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        dbSettings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
        dbSettings.put(Environment.SHOW_SQL, "true");
        dbSettings.put(Environment.HBM2DDL_AUTO, "update");
        return dbSettings;
    }

    public static void close() {
        SESSION_FACTORY.close();
    }
}
