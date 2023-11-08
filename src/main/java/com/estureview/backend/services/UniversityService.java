package com.estureview.backend.services;

import com.estureview.backend.dtos.UniversityDTO;


import java.util.List;

public interface UniversityService {
    List<UniversityDTO> findAll();
    UniversityDTO findById(Integer id);
    UniversityDTO save(UniversityDTO universityDTO);

    UniversityDTO update(UniversityDTO universityDTO);
    void deleteById(Integer id);
}
