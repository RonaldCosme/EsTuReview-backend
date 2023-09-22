package com.estureview.backend.services;

import com.estureview.backend.dtos.ModerationActionDTO;
import java.util.List;

public interface ModerationActionService {

    ModerationActionDTO createModerationAction(ModerationActionDTO moderationActionDTO);
    List<ModerationActionDTO> listAllModerationActions();
    ModerationActionDTO findModerationActionById(Integer id);
    void deleteModerationAction(Integer id);
    ModerationActionDTO updateModerationAction(ModerationActionDTO moderationActionDTO);
}
