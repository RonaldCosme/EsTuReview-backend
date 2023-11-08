package com.estureview.backend.controllers;

import com.estureview.backend.dtos.CourseDTO;
import com.estureview.backend.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Integer id) {
        CourseDTO courseDTO = courseService.findById(id);
        return courseDTO != null ?
                new ResponseEntity<>(courseDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO, @PathVariable Integer id) {
        CourseDTO foundCourse = courseService.findById(id);
        if (courseDTO.getCourseName()!=null) {
            foundCourse.setCourseName(courseDTO.getCourseName());
        }
        if (courseDTO.getCourseCode()!=null) {
            foundCourse.setCourseCode(courseDTO.getCourseCode());
        }
        if (courseDTO.getDescription()!=null) {
            foundCourse.setDescription(courseDTO.getDescription());
        }
        if (courseDTO.getUniversityId()!=null) {
            foundCourse.setUniversityId(courseDTO.getUniversityId());
        }
        CourseDTO newCourse = courseService.save(foundCourse);
        return new ResponseEntity<>(newCourse, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        return new ResponseEntity<>(courseService.save(courseDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
