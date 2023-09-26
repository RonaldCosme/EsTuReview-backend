package com.estureview.backend.controllers;

import com.estureview.backend.dtos.UserAppDTO;
import com.estureview.backend.services.UserAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userApps")
public class UserAppController {

    @Autowired
    private UserAppService userAppService;

    @GetMapping
    public ResponseEntity<List<UserAppDTO>> getAllUserApps() {
        return new ResponseEntity<>(userAppService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAppDTO> getUserAppById(@PathVariable Integer id) {
        UserAppDTO userAppDTO = userAppService.findById(id);
        if (userAppDTO != null) {
            return new ResponseEntity<>(userAppDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<UserAppDTO> createUserApp(@RequestBody UserAppDTO userAppDTO) {
        return new ResponseEntity<>(userAppService.save(userAppDTO), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserApp(@PathVariable Integer id) {
        userAppService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
