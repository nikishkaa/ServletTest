package org.example.servlettest.test;

import java.util.Date;

import org.example.servlettest.entity.Employee;
import org.example.servlettest.util.HibernateUtil;
import org.hibernate.Session;


public class HibernateMain {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Pankaj");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());

        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID="+emp.getId());


        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setRole("Developer");
        emp2.setInsertTime(new Date());
        Session session2 =  HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session2.beginTransaction();
        //Save the Model object
        session2.save(emp2);
        //Commit transaction
        session2.getTransaction().commit();
        System.out.println("Employee ID="+emp2.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }

}