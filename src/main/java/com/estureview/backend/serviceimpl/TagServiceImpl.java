package com.estureview.backend.serviceimpl;

import com.estureview.backend.entities.Tag;
import com.estureview.backend.repositories.TagRepository;
import com.estureview.backend.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> listAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findTagById(Long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        return tag.orElse(null);
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }

    @Override
    public Tag updateTag(Tag tag) {
        if (tag.getTagId() == null) {
            return null; // or throw an exception
        }
        return tagRepository.save(tag);
    }
}