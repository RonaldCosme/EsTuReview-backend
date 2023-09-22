package com.estureview.backend.controllers;

import com.estureview.backend.dtos.ProfessorDTO;
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
    public ResponseEntity<ProfessorDTO> createProfessor(@RequestBody ProfessorDTO professorDTO) {
        return ResponseEntity.ok(professorService.createProfessor(professorDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> listAllProfessors() {
        return ResponseEntity.ok(professorService.listAllProfessors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> findProfessorById(@PathVariable Integer id) {
        return ResponseEntity.ok(professorService.findProfessorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Integer id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ProfessorDTO> updateProfessor(@RequestBody ProfessorDTO professorDTO) {
        return ResponseEntity.ok(professorService.updateProfessor(professorDTO));
    }
}
