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

    @GetMapping
    public ResponseEntity<List<UserAppDTO>> getAllUsers() {
        return ResponseEntity.ok(userAppService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAppDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok(userAppService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserAppDTO> createUser(@RequestBody UserAppDTO userAppDTO) {
        return ResponseEntity.ok(userAppService.createUser(userAppDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserAppDTO> updateUser(@PathVariable Long id, @RequestBody UserAppDTO userAppDTO) {
        return ResponseEntity.ok(userAppService.updateUser(id, userAppDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userAppService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
