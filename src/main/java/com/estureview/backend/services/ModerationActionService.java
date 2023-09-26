package com.estureview.backend.services;

import com.estureview.backend.dtos.ModerationActionDTO;

import java.util.List;

public interface ModerationActionService {
    List<ModerationActionDTO> findAll();
    ModerationActionDTO findById(Integer id);
    ModerationActionDTO save(ModerationActionDTO moderationActionDTO);
    void deleteById(Integer id);
}