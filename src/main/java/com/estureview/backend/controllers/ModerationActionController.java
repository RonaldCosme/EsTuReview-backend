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

    @GetMapping
    public ResponseEntity<List<ModerationActionDTO>> getAllModerationActions() {
        return ResponseEntity.ok(moderationActionService.getAllModerationActions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModerationActionDTO> getModerationActionById(@PathVariable Long id) {
        return ResponseEntity.ok(moderationActionService.getModerationActionById(id));
    }

    @PostMapping
    public ResponseEntity<ModerationActionDTO> createModerationAction(@RequestBody ModerationActionDTO moderationActionDTO) {
        return ResponseEntity.ok(moderationActionService.createModerationAction(moderationActionDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModerationActionDTO> updateModerationAction(@PathVariable Long id, @RequestBody ModerationActionDTO moderationActionDTO) {
        return ResponseEntity.ok(moderationActionService.updateModerationAction(id, moderationActionDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModerationAction(@PathVariable Long id) {
        moderationActionService.deleteModerationAction(id);
        return ResponseEntity.noContent().build();
    }
}
