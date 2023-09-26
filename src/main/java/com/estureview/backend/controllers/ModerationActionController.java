package com.estureview.backend.controllers;

import com.estureview.backend.dtos.ModerationActionDTO;
import com.estureview.backend.services.ModerationActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moderationActions")
public class ModerationActionController {

    @Autowired
    private ModerationActionService moderationActionService;

    @GetMapping
    public ResponseEntity<List<ModerationActionDTO>> getAllModerationActions() {
        return new ResponseEntity<>(moderationActionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModerationActionDTO> getModerationActionById(@PathVariable Integer id) {
        ModerationActionDTO moderationActionDTO = moderationActionService.findById(id);
        return moderationActionDTO != null ?
                new ResponseEntity<>(moderationActionDTO, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<ModerationActionDTO> createModerationAction(@RequestBody ModerationActionDTO moderationActionDTO) {
        return new ResponseEntity<>(moderationActionService.save(moderationActionDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModerationAction(@PathVariable Integer id) {
        moderationActionService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
