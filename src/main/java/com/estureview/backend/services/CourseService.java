package com.estureview.backend.services;

import com.estureview.backend.dtos.CourseDTO;

import java.util.List;

public interface CourseService {
    List<CourseDTO> findAll();
    CourseDTO findById(Integer id);
    CourseDTO save(CourseDTO courseDTO);
    void deleteById(Integer id);
}