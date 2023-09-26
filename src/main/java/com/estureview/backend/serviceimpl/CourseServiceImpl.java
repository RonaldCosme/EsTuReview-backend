package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.CourseDTO;
import com.estureview.backend.entities.Course;
import com.estureview.backend.repositories.CourseRepository;
import com.estureview.backend.services.CourseService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<CourseDTO> findAll() {
        return courseRepository.findAll()
                .stream()
                .map(course -> modelMapper.map(course, CourseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDTO findById(Integer id) {
        Course course = courseRepository.findById(id).orElse(null);
        return course != null ? modelMapper.map(course, CourseDTO.class) : null;
    }

    @Override
    public CourseDTO save(CourseDTO courseDTO) {
        Course course = modelMapper.map(courseDTO, Course.class);
        course = courseRepository.save(course);
        return modelMapper.map(course, CourseDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }
}

