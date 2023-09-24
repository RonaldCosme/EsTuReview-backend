package com.estureview.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id",updatable = false,nullable = false)
    private Long courseId;

    @Column(nullable = false)
    private String codeCourse;
    private String nameCourse;
    private String codeCareerCourse;

}
