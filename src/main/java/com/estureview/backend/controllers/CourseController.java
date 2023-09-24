package com.estureview.backend.controllers;

import com.estureview.backend.dtos.CourseDTO;
import com.estureview.backend.services.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO){
        CourseDTO createCourse=courseService.createCourse(courseDTO);
        return ResponseEntity.ok(createCourse);
    }

    @GetMapping
    public ResponseEntity<List<CourseDTO>> listAllCourse(){
        List<CourseDTO> courses = courseService.listAllCourse();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable Long id){
        CourseDTO courseDTO = courseService.findCourseByIdOrCodeCourse(id,null);
        if (courseDTO!=null)
        {
            return ResponseEntity.ok(courseDTO);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("search")
    public ResponseEntity<CourseDTO> getCourseByCodeCourse(@PathVariable String codeCourse){
        CourseDTO courseDTO = courseService.findCourseByIdOrCodeCourse(null,codeCourse);
        if (courseDTO!=null)
        {
            return ResponseEntity.ok(courseDTO);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id){
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> updateCourse(@PathVariable Long id,@RequestBody CourseDTO courseDTO){
        if(!id.equals(courseDTO.getCourseId()))
        {
            return ResponseEntity.badRequest().build();
        }
        CourseDTO updateCourse = courseService.updateCourse(courseDTO);
        return ResponseEntity.ok(updateCourse);
    }
}
