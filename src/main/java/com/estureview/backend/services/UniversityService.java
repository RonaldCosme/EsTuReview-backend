package com.estureview.backend.services;


import com.estureview.backend.entities.University;

import java.util.List;

public interface UniversityService {
    University createUniversity(University university);
    List<University> listAllUniversities();
    University findUniversityByIdOrName(Long id, String name);
    void deleteUniversity(Long id);
    University updateUniversity(University university);
}