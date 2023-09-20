package com.estureview.backend.services;

import com.estureview.backend.entities.Course;
import com.estureview.backend.entities.University;

import java.util.List;

import java.util.List;

public interface CourseService {
    Course createCourse(Course course);
    List<Course> listAllCourses();
    Course findCourseById(Long id);
    void deleteCourse(Long id);
    Course updateCourse(Course course);
}