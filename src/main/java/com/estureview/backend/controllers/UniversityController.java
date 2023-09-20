package com.estureview.backend.controllers;

import com.estureview.backend.entities.University;
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
    public ResponseEntity<University> createUniversity(@RequestBody University university) {
        return ResponseEntity.ok(universityService.createUniversity(university));
    }

    @GetMapping
    public ResponseEntity<List<University>> listAllUniversities() {
        return ResponseEntity.ok(universityService.listAllUniversities());
    }

    @GetMapping("/{id}")
    public ResponseEntity<University> findUniversityById(@PathVariable Long id) {
        return ResponseEntity.ok(universityService.findUniversityByIdOrName(id, null));
    }

    @GetMapping("/search")
    public ResponseEntity<University> findUniversityByName(@RequestParam String name) {
        return ResponseEntity.ok(universityService.findUniversityByIdOrName(null, name));
    }

    @PutMapping("/{id}")
    public ResponseEntity<University> updateUniversity(@PathVariable Long id, @RequestBody University university) {
        university.setUniversityId(id);
        return ResponseEntity.ok(universityService.updateUniversity(university));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUniversity(@PathVariable Long id) {
        universityService.deleteUniversity(id);
        return ResponseEntity.noContent().build();
    }
}
