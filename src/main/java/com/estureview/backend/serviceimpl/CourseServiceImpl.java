package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.CourseDTO;
import com.estureview.backend.entities.Course;
import com.estureview.backend.repositories.CourseRepository;
import com.estureview.backend.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class  CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<CourseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(CourseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO getCourseById(Long id) {
        return courseRepository.findById(id)
                .map(CourseDTO::new)
                .orElse(null);
    }

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = new Course();

        // Set course properties from courseDTO...
        course = courseRepository.save(course);
        return new CourseDTO(course);
    }

    @Override
    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            // Update course properties from courseDTO...
            course = courseRepository.save(course);
        }
        return new CourseDTO(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}