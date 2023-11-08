package com.estureview.backend.controllers;

import com.estureview.backend.dtos.ProfessorDTO;
import com.estureview.backend.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/professors")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<ProfessorDTO>> getAllProfessors() {
        return new ResponseEntity<>(professorService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getProfessorById(@PathVariable Integer id) {
        ProfessorDTO professorDTO = professorService.findById(id);
        return professorDTO != null ?
                new ResponseEntity<>(professorDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDTO> updateProfessor(@RequestBody ProfessorDTO professorDTO, @PathVariable Integer id) {
        ProfessorDTO foundProfessor = professorService.findById(id);
        if (professorDTO.getFaculty()!=null) {
            foundProfessor.setFaculty(professorDTO.getFaculty());
        }
        if (professorDTO.getJoinDate()!=null) {
            foundProfessor.setJoinDate(professorDTO.getJoinDate());
        }
        if (professorDTO.getUserappId()!=null) {
            foundProfessor.setUserappId(professorDTO.getUserappId());
        }
        ProfessorDTO newProfessor = professorService.save(foundProfessor);
        return new ResponseEntity<>(newProfessor, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> createProfessor(@RequestBody ProfessorDTO professorDTO) {
        return new ResponseEntity<>(professorService.save(professorDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Integer id) {
        professorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
