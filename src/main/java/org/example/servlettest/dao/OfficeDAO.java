package org.example.servlettest.dao;

import org.example.servlettest.model.Office;

import java.util.Set;

public interface OfficeDAO {

    Set<Office> findAll();
}
