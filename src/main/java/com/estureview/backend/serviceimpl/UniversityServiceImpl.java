package com.estureview.backend.serviceimpl;

import com.estureview.backend.entities.University;
import com.estureview.backend.repositories.UniversityRepository;
import com.estureview.backend.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversityServiceImpl implements UniversityService {

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public University createUniversity(University university) {
        return universityRepository.save(university);
    }

    @Override
    public List<University> listAllUniversities() {
        return universityRepository.findAll();
    }

    @Override
    public University findUniversityByIdOrName(Long id, String name) {
        if (id != null) {
            Optional<University> university = universityRepository.findById(id);
            return university.orElse(null);
        }
        // Assuming there's a method in your repository to find by name
        return universityRepository.findByName(name);
    }

    @Override
    public void deleteUniversity(Long id) {
        universityRepository.deleteById(id);
    }

    @Override
    public University updateUniversity(University university) {
        if (university.getUniversityId() == null) {
            return null; // or throw an exception
        }
        return universityRepository.save(university);
    }
}