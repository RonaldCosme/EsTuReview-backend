package com.estureview.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "University")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Integer universityId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "campus")
    private String campus;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "university")
    private List<User> users;

    @OneToMany(mappedBy = "university")
    private List<Course> courses;

    // Getters, Setters, Constructors, equals(), hashCode(), toString()
}






