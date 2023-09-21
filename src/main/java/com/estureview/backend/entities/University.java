package com.estureview.backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long university_id;

    private String name;
    private String campus;
    private String location;
    private String description;

    @OneToMany(mappedBy = "university")
    private List<UserApp> users;

    @OneToMany(mappedBy = "university")
    private List<Course> courses;


    // getters, setters, constructors...
}






