package com.estureview.backend.controllers;

import com.estureview.backend.dtos.CourseDTO;
import com.estureview.backend.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.createCourse(courseDTO));
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> listAllCourses() {
        return ResponseEntity.ok(courseService.listAllCourses());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> findCourseById(@PathVariable Integer id) {
        return ResponseEntity.ok(courseService.findCourseById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<CourseDTO> updateCourse(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity.ok(courseService.updateCourse(courseDTO));
    }
}
