package com.estureview.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDTO {

    private Integer courseId;
    private String courseName;
    private String courseCode;
    private String description;
    private Integer universityId;

    // Getters and Setters
}
