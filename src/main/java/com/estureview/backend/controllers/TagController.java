package com.estureview.backend.controllers;

import com.estureview.backend.entities.Tag;
import com.estureview.backend.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return ResponseEntity.ok(tagService.createTag(tag));
    }

    @GetMapping
    public ResponseEntity<List<Tag>> listAllTags() {
        return ResponseEntity.ok(tagService.listAllTags());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tag> findTagById(@PathVariable Long id) {
        return ResponseEntity.ok(tagService.findTagById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tag> updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        tag.setTagId(id);
        return ResponseEntity.ok(tagService.updateTag(tag));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}