package com.estureview.backend.services;


import com.estureview.backend.dtos.UniversityDTO;

import java.util.List;

public interface UniversityService {

    UniversityDTO createUniversity(UniversityDTO universityDTO);
    List<UniversityDTO> listAllUniversities();
    UniversityDTO findUniversityByIdOrName(Long id, String name);
    void deleteUniversity(Long id);
    UniversityDTO updateUniversity(UniversityDTO universityDTO);
}