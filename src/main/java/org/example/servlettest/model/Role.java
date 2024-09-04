package org.example.servlettest.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.servlettest.entity.Item;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ROLE")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "user")
    private Set<User> users;
}
