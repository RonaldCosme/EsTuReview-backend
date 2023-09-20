package com.estureview.backend.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "course_name", nullable = false)
    private String courseName;

    @Column(name = "course_code", nullable = false, unique = true)
    private String courseCode;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @Column(name = "faculty")
    private String faculty;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews;

    // Getters, Setters, Constructors, equals(), hashCode(), toString()
}