package org.example.servlettest.dao.impl;

import org.example.servlettest.dao.AbstractDao;
import org.example.servlettest.entity.Employee;

public class EmployeeDao extends AbstractDao<Integer, Employee> {

    public Employee findByEmail(String email) {
        getSession();
//TODO

    }

}
