package org.example.servlettest.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class User {
    private int id;
    private String name;
    private String email;
    private String password;
    public Timestamp createdTs;
    public Timestamp updatedTs;


}
