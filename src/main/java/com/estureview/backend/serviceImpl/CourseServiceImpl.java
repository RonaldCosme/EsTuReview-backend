package com.estureview.backend.serviceImpl;

import com.estureview.backend.dtos.CourseDTO;
import com.estureview.backend.entities.Course;
import com.estureview.backend.repositories.CourseRepository;
import com.estureview.backend.services.CourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
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
        BeanUtils.copyProperties(courseDTO,course);
        course = courseRepository.save(course);
        BeanUtils.copyProperties(course, courseDTO);
        return courseDTO;
    }

    @Override
    public List<CourseDTO> listAllCourse() {
        List<Course> courses = courseRepository.findAll();
        List<CourseDTO> courseDTOS = new ArrayList<>();
        for (Course course : courses) {
            CourseDTO courseDTO= new CourseDTO();
            BeanUtils.copyProperties(course,courseDTO);
            courseDTOS.add(courseDTO);
        }
        return courseDTOS;
    }

    @Override
    public CourseDTO findCourseByIdOrCodeCourse(Long id, String codeCourse) {
        Optional<Course> courseOptional;
        if (id!=null){
            courseOptional = courseRepository.findById(id);
        }else {
            throw new UnsupportedOperationException("Buscar por Coigo de curso aun falta");
        }
        if (courseOptional.isPresent()){
            CourseDTO courseDTO = new CourseDTO();
            BeanUtils.copyProperties(courseOptional.get(),courseDTO);
            return courseDTO;
        }
        return null;
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public CourseDTO updateCourse(CourseDTO courseDTO) {
        if (courseDTO.getCourseId()==null){
            throw new IllegalArgumentException("Se necesita el Id para la acutalizacion");
        }
        Course course =new Course();
        BeanUtils.copyProperties(courseDTO,course);
        course= courseRepository.save(course);
        BeanUtils.copyProperties(course,courseDTO);
        return courseDTO;
    }
}
