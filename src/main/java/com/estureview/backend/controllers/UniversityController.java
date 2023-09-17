package com.estureview.backend.controllers;

import com.estureview.backend.dtos.UniversityDTO;
import com.estureview.backend.services.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @PostMapping
    public ResponseEntity<UniversityDTO> createUniversity(@RequestBody UniversityDTO universityDTO) {
        UniversityDTO createdUniversity = universityService.createUniversity(universityDTO);
        return ResponseEntity.ok(createdUniversity);
    }

    @GetMapping
    public ResponseEntity<List<UniversityDTO>> listAllUniversities() {
        List<UniversityDTO> universities = universityService.listAllUniversities();
        return ResponseEntity.ok(universities);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UniversityDTO> getUniversityById(@PathVariable Long id) {
        UniversityDTO universityDTO = universityService.findUniversityByIdOrName(id, null);
        if (universityDTO != null) {
            return ResponseEntity.ok(universityDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public ResponseEntity<UniversityDTO> getUniversityByName(@RequestParam String name) {
        UniversityDTO universityDTO = universityService.findUniversityByIdOrName(null, name);
        if (universityDTO != null) {
            return ResponseEntity.ok(universityDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UniversityDTO> updateUniversity(@PathVariable Long id, @RequestBody UniversityDTO universityDTO) {
        if (!id.equals(universityDTO.getUniversityId())) {
            return ResponseEntity.badRequest().build();
        }
        UniversityDTO updatedUniversity = universityService.updateUniversity(universityDTO);
        return ResponseEntity.ok(updatedUniversity);
    }
}