package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.CourseDTO;
import com.estureview.backend.entities.Course;
import com.estureview.backend.repositories.CourseRepository;
import com.estureview.backend.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        course = courseRepository.save(course);
        BeanUtils.copyProperties(course, courseDTO);
        return courseDTO;
    }

    @Override
    public List<CourseDTO> listAllCourses() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOs = new ArrayList<>();
        for (Course course : courses) {
            CourseDTO courseDTO = new CourseDTO();
            BeanUtils.copyProperties(course, courseDTO);
            courseDTOs.add(courseDTO);
        }
        return courseDTOs;
    }

    @Override
    public CourseDTO findCourseById(Integer id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if (courseOptional.isPresent()) {
            CourseDTO courseDTO = new CourseDTO();
            BeanUtils.copyProperties(courseOptional.get(), courseDTO);
            return courseDTO;
        }
        return null;
    }

    @Override
    public void deleteCourse(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        if (courseDTO.getId() == null) {
            throw new IllegalArgumentException("El ID del curso es necesario para actualizar");
        }
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);
        course = courseRepository.save(course);
        BeanUtils.copyProperties(course, courseDTO);
        return courseDTO;
    }
}