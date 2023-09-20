package com.estureview.backend.serviceimpl;

import com.estureview.backend.entities.ModerationAction;
import com.estureview.backend.repositories.ModerationActionRepository;
import com.estureview.backend.services.ModerationActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModerationActionServiceImpl implements ModerationActionService {

    @Autowired
    private ModerationActionRepository moderationActionRepository;

    @Override
    public ModerationAction createModerationAction(ModerationAction moderationAction) {
        return moderationActionRepository.save(moderationAction);
    }

    @Override
    public List<ModerationAction> listAllModerationActions() {
        return moderationActionRepository.findAll();
    }

    @Override
    public ModerationAction findModerationActionById(Long id) {
        Optional<ModerationAction> action = moderationActionRepository.findById(id);
        return action.orElse(null);
    }

    @Override
    public void deleteModerationAction(Long id) {
        moderationActionRepository.deleteById(id);
    }

    @Override
    public ModerationAction updateModerationAction(ModerationAction moderationAction) {
        if (moderationAction.getActionId() == null) {
            return null; // or throw an exception
        }
        return moderationActionRepository.save(moderationAction);
    }
}
