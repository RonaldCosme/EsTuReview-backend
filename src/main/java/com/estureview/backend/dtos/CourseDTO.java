package com.estureview.backend.dtos;

import com.estureview.backend.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long course_id;
    private String course_name;
    private String course_code;
    private Long university_id;
    private String description;

    public CourseDTO(Course course) {
    }

    // getters, setters, constructors...
}