package com.estureview.backend.services;


import com.estureview.backend.dtos.UniversityDTO;
import java.util.List;

public interface UniversityService {

    UniversityDTO createUniversity(UniversityDTO universityDTO);
    List<UniversityDTO> listAllUniversities();
    UniversityDTO findUniversityById(Integer id);
    void deleteUniversity(Integer id);
    UniversityDTO updateUniversity(UniversityDTO universityDTO);
}