package com.estureview.backend.controllers;

import com.estureview.backend.dtos.UniversityDTO;
import com.estureview.backend.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @GetMapping
    public ResponseEntity<List<UniversityDTO>> getAllUniversities() {
        return new ResponseEntity<>(universityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityDTO> getUniversityById(@PathVariable Integer id) {
        UniversityDTO universityDTO = universityService.findById(id);
        return universityDTO != null ?
                new ResponseEntity<>(universityDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityDTO> updateUniversity(@RequestBody UniversityDTO universityDTO, @PathVariable Integer id) {
        UniversityDTO foundUniversity = universityService.findById(id);
        if (universityDTO.getName()!=null) {
            foundUniversity.setName(universityDTO.getName());
        }
        if (universityDTO.getCampus()!=null) {
            foundUniversity.setCampus(universityDTO.getCampus());
        }
        if (universityDTO.getLocation()!=null) {
            foundUniversity.setLocation(universityDTO.getLocation());
        }
        if (universityDTO.getDescription()!=null) {
            foundUniversity.setDescription(universityDTO.getDescription());
        }
        UniversityDTO newUniversity = universityService.save(foundUniversity);
        return new ResponseEntity<>(newUniversity, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<UniversityDTO> createUniversity(@RequestBody UniversityDTO universityDTO) {
        return new ResponseEntity<>(universityService.save(universityDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Integer id) {
        universityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
