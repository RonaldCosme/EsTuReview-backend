package com.estureview.backend.controllers;

import com.estureview.backend.dtos.ModerationActionDTO;
import com.estureview.backend.services.ModerationActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/moderation-actions")
public class ModerationActionController {

    @Autowired
    private ModerationActionService moderationActionService;

    @PostMapping
    public ResponseEntity<ModerationActionDTO> createModerationAction(@RequestBody ModerationActionDTO moderationActionDTO) {
        return ResponseEntity.ok(moderationActionService.createModerationAction(moderationActionDTO));
    }

    @GetMapping
    public ResponseEntity<List<ModerationActionDTO>> listAllModerationActions() {
        return ResponseEntity.ok(moderationActionService.listAllModerationActions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModerationActionDTO> findModerationActionById(@PathVariable Integer id) {
        return ResponseEntity.ok(moderationActionService.findModerationActionById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModerationAction(@PathVariable Integer id) {
        moderationActionService.deleteModerationAction(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<ModerationActionDTO> updateModerationAction(@RequestBody ModerationActionDTO moderationActionDTO) {
        return ResponseEntity.ok(moderationActionService.updateModerationAction(moderationActionDTO));
    }
}