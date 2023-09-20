package com.estureview.backend.services;

import com.estureview.backend.entities.ModerationAction;

import java.util.List;

public interface ModerationActionService {
    ModerationAction createModerationAction(ModerationAction moderationAction);
    List<ModerationAction> listAllModerationActions();
    ModerationAction findModerationActionById(Long id);
    void deleteModerationAction(Long id);
    ModerationAction updateModerationAction(ModerationAction moderationAction);
}