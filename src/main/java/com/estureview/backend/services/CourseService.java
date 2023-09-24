package com.estureview.backend.services;

import com.estureview.backend.dtos.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);
    List<CourseDTO> listAllCourse();
    CourseDTO findCourseByIdOrCodeCourse(Long id,String codeCourse);
    void deleteCourse(Long id);
    CourseDTO updateCourse(CourseDTO courseDTO);
}
