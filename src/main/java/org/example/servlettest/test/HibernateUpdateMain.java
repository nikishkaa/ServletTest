package org.example.servlettest.test;

import org.example.servlettest.entity.Employee;
import org.example.servlettest.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import java.util.Date;


public class HibernateUpdateMain {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();

        Employee employee = (Employee) session.get(Employee.class, 19);


        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }

}