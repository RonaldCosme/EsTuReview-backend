package com.estureview.backend.controllers;

import com.estureview.backend.entities.Professor;
import com.estureview.backend.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.createProfessor(professor));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listAllProfessors() {
        return ResponseEntity.ok(professorService.listAllProfessors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> findProfessorById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.findProfessorById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        professor.setProfessorId(id);
        return ResponseEntity.ok(professorService.updateProfessor(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}