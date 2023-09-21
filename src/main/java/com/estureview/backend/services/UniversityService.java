package com.estureview.backend.services;


import com.estureview.backend.dtos.UniversityDTO;
import java.util.List;

public interface UniversityService {
    List<UniversityDTO> getAllUniversities();
    UniversityDTO getUniversityById(Long id);
    UniversityDTO createUniversity(UniversityDTO universityDTO);
    UniversityDTO updateUniversity(Long id, UniversityDTO universityDTO);
    void deleteUniversity(Long id);
}