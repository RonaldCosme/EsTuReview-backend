package com.estureview.backend.services;

import com.estureview.backend.entities.Tag;

import java.util.List;

public interface TagService {
    Tag createTag(Tag tag);
    List<Tag> listAllTags();
    Tag findTagById(Long id);
    void deleteTag(Long id);
    Tag updateTag(Tag tag);
}