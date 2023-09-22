package com.estureview.backend.services;

import com.estureview.backend.dtos.CourseDTO;
import java.util.List;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);
    List<CourseDTO> listAllCourses();
    CourseDTO findCourseById(Integer id);
    void deleteCourse(Integer id);
    CourseDTO updateCourse(CourseDTO courseDTO);
}