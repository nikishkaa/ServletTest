package org.example.servlettest.test;

import org.example.servlettest.dao.impl.EmployeeDao;
import org.example.servlettest.db.JPAService;
import org.example.servlettest.db.config.JpaConfiguration;
import org.example.servlettest.entity.Employee;

public class NewHiberTest {
    public static void main(String[] args) {

        JPAService.initialize();

        EmployeeDao employeeDao = new EmployeeDao();
        employeeDao.findAll().forEach(employee -> System.out.println());


        Employee employee1 = new Employee();
        employee1.setName("John");
        employee1.setRole("MANAGER");

        Employee employee2 = new Employee();
        employee2.setName("John");
        employee2.setRole("MANAGER");

        employeeDao.create(employee1);
        employeeDao.create(employee2);
        employeeDao.findAll().forEach(employee -> System.out.println(employee));


    }
}
