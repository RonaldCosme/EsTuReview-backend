package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.UniversityDTO;
import com.estureview.backend.entities.University;
import com.estureview.backend.repositories.UniversityRepository;
import com.estureview.backend.services.UniversityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public UniversityDTO createUniversity(UniversityDTO universityDTO) {
        University university = new University();
        BeanUtils.copyProperties(universityDTO, university);
        university = universityRepository.save(university);
        BeanUtils.copyProperties(university, universityDTO);
        return universityDTO;
    }

    @Override
    public List<UniversityDTO> listAllUniversities() {
        List<University> universities = universityRepository.findAll();
        List<UniversityDTO> universityDTOs = new ArrayList<>();
        for (University university : universities) {
            UniversityDTO universityDTO = new UniversityDTO();
            BeanUtils.copyProperties(university, universityDTO);
            universityDTOs.add(universityDTO);
        }
        return universityDTOs;
    }

    @Override
    public UniversityDTO findUniversityById(Integer id) {
        Optional<University> universityOptional = universityRepository.findById(id);
        if (universityOptional.isPresent()) {
            UniversityDTO universityDTO = new UniversityDTO();
            BeanUtils.copyProperties(universityOptional.get(), universityDTO);
            return universityDTO;
        }
        return null;
    }

    @Override
    public void deleteUniversity(Integer id) {
        universityRepository.deleteById(id);
    }

    @Override
    public UniversityDTO updateUniversity(UniversityDTO universityDTO) {
        if (universityDTO.getId() == null) {
            throw new IllegalArgumentException("El ID de la universidad es necesario para actualizar");
        }
        University university = new University();
        BeanUtils.copyProperties(universityDTO, university);
        university = universityRepository.save(university);
        BeanUtils.copyProperties(university, universityDTO);
        return universityDTO;
    }
}