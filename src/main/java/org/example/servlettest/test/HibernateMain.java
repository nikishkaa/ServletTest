package org.example.servlettest.test;

import org.example.servlettest.dao.impl.EmployeeDao;
import org.example.servlettest.entity.Employee;
import org.example.servlettest.util.HibernateAnnotationUtil;
import org.example.servlettest.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class HibernateMain {

    static EmployeeDao dao = new EmployeeDao();

    public static void main(String[] args) {

        Employee empl = dao.getByKey(19);
        System.out.println(empl);

//
//        Transaction txn = null;
//        try (Session session = HibernateAnnotationUtil.getSessionFactory().getCurrentSession()) {
//
//            //start transaction
//            txn = session.beginTransaction();
//            Employee empl = session.get(Employee.class, 19);
//            txn.commit();
//
//            System.out.println(empl);
//        } catch (Exception e) {
//            e.printStackTrace();
//            if (txn != null) {
//                txn.rollback();
//            }
//        } finally {
//            //terminate session factory, otherwise program wont end
//            HibernateAnnotationUtil.close();
//        }

    }

}
