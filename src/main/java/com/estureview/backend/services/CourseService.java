package com.estureview.backend.services;

import com.estureview.backend.dtos.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();
    CourseDTO findById(Long id);
    CourseDTO save(CourseDTO courseDTO);
    void deleteById(Long id);
}