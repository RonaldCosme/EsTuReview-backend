package com.estureview.backend.controllers;

import com.estureview.backend.entities.ModerationAction;
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
    public ResponseEntity<ModerationAction> createModerationAction(@RequestBody ModerationAction moderationAction) {
        return ResponseEntity.ok(moderationActionService.createModerationAction(moderationAction));
    }

    @GetMapping
    public ResponseEntity<List<ModerationAction>> listAllModerationActions() {
        return ResponseEntity.ok(moderationActionService.listAllModerationActions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModerationAction> findModerationActionById(@PathVariable Long id) {
        return ResponseEntity.ok(moderationActionService.findModerationActionById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModerationAction> updateModerationAction(@PathVariable Long id, @RequestBody ModerationAction moderationAction) {
        moderationAction.setActionId(id);
        return ResponseEntity.ok(moderationActionService.updateModerationAction(moderationAction));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModerationAction(@PathVariable Long id) {
        moderationActionService.deleteModerationAction(id);
        return ResponseEntity.noContent().build();
    }
}