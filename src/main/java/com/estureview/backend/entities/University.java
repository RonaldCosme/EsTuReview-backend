package com.estureview.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "University")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "university_id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "campus")
    private String campus;

    @Column(name = "location")
    private String location;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "university")
    private List<UserApp> users;

    @OneToMany(mappedBy = "university")
    private List<Course> courses;

    // Getters y Setters
}







