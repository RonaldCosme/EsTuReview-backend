package com.estureview.backend.services;

import com.estureview.backend.dtos.ModerationActionDTO;
import java.util.List;

public interface ModerationActionService {
    List<ModerationActionDTO> getAllModerationActions();
    ModerationActionDTO getModerationActionById(Long id);
    ModerationActionDTO createModerationAction(ModerationActionDTO moderationActionDTO);
    ModerationActionDTO updateModerationAction(Long id, ModerationActionDTO moderationActionDTO);
    void deleteModerationAction(Long id);
}