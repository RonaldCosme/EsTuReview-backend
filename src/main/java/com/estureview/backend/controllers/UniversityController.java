package com.estureview.backend.controllers;

import com.estureview.backend.dtos.UniversityDTO;
import com.estureview.backend.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(universityService.getAllUniversities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityDTO> getUniversityById(@PathVariable Long id) {
        return ResponseEntity.ok(universityService.getUniversityById(id));
    }

    @PostMapping
    public ResponseEntity<UniversityDTO> createUniversity(@RequestBody UniversityDTO universityDTO) {
        return ResponseEntity.ok(universityService.createUniversity(universityDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityDTO> updateUniversity(@PathVariable Long id, @RequestBody UniversityDTO universityDTO) {
        return ResponseEntity.ok(universityService.updateUniversity(id, universityDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }
}