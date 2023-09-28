package com.estureview.backend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Set<UserApp> users;

    @OneToMany(mappedBy = "university")
    private Set<Course> courses;


    // Getters and Setters
}







