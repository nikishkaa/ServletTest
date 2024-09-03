package org.example.servlettest.model;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.servlettest.entity.Item;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private int id;
    private String name;
    private String description;


    @OneToMany(mappedBy = "user")
    private Set<User> users;
}
