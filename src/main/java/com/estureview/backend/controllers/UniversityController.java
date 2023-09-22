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

    @PostMapping
    public ResponseEntity<UniversityDTO> createUniversity(@RequestBody UniversityDTO universityDTO) {
        return ResponseEntity.ok(universityService.createUniversity(universityDTO));
    }

    @GetMapping
    public ResponseEntity<List<UniversityDTO>> listAllUniversities() {
        return ResponseEntity.ok(universityService.listAllUniversities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityDTO> findUniversityById(@PathVariable Integer id) {
        return ResponseEntity.ok(universityService.findUniversityById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Integer id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UniversityDTO> updateUniversity(@RequestBody UniversityDTO universityDTO) {
        return ResponseEntity.ok(universityService.updateUniversity(universityDTO));
    }
}