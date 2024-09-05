package org.example.servlettest.test;

import org.example.servlettest.dao.impl.StudentDao;
import org.example.servlettest.db.JPAService;
import org.example.servlettest.db.config.JpaConfiguration;
import org.example.servlettest.entity.Student;

import java.util.List;

public class StudentHibernateTest {
    public static void main(String[] args) {

        JPAService.initialize();


//        StudentDao studentDao = new StudentDao();
//        studentDao.findAll().forEach(employee -> System.out.println());
//
//        Student student = new Student();
//        student.setName("John");
//
//
//        Student student1 = new Student();
//        student1.setName("john1");
//
//        studentDao.create(student1);
//        studentDao.create(student);


        StudentDao studentDao = new StudentDao();

        studentDao.findAll("name like 'john1'");

        List<Student> studentDaolist = studentDao.findAll("name like 'john1'");

        System.out.println(studentDaolist.size());

//        studentDao.findAll().forEach(employee -> System.out.println(studentDao));


    }
}
