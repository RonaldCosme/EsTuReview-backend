package com.estureview.backend.controllers;


import com.estureview.backend.dtos.UserAppDTO;
import com.estureview.backend.services.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserAppController {

    @Autowired
    private UserAppService userAppService;

    @PostMapping
    public ResponseEntity<UserAppDTO> createUserApp(@RequestBody UserAppDTO userAppDTO) {
        return ResponseEntity.ok(userAppService.createUserApp(userAppDTO));
    }

    @GetMapping
    public ResponseEntity<List<UserAppDTO>> listAllUserApps() {
        return ResponseEntity.ok(userAppService.listAllUserApps());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAppDTO> findUserAppById(@PathVariable Integer id) {
        return ResponseEntity.ok(userAppService.findUserAppById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserApp(@PathVariable Integer id) {
        userAppService.deleteUserApp(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<UserAppDTO> updateUserApp(@RequestBody UserAppDTO userAppDTO) {
        return ResponseEntity.ok(userAppService.updateUserApp(userAppDTO));
    }
}