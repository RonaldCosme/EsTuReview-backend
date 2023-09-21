package com.estureview.backend.serviceimpl;
import com.estureview.backend.dtos.ModerationActionDTO;
import com.estureview.backend.entities.ModerationAction;
import com.estureview.backend.repositories.ModerationActionRepository;
import com.estureview.backend.services.ModerationActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModerationActionServiceImpl implements ModerationActionService {

    @Autowired
    private ModerationActionRepository moderationActionRepository;

    @Override
    public List<ModerationActionDTO> getAllModerationActions() {
        return moderationActionRepository.findAll().stream()
                .map(ModerationActionDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public ModerationActionDTO getModerationActionById(Long id) {
        return moderationActionRepository.findById(id)
                .map(ModerationActionDTO:: new)
                .orElse(null);
    }

    @Override
    public ModerationActionDTO createModerationAction(ModerationActionDTO moderationActionDTO) {
        ModerationAction moderationAction = new ModerationAction();
        moderationAction.setAction_id(moderationActionDTO.getAction_id());
        moderationAction.setAction_type(moderationActionDTO.getAction_type());
        moderationAction.setAction_date(moderationActionDTO.getAction_date());
        moderationAction.setComment(moderationActionDTO.getComment());
        moderationAction = moderationActionRepository.save(moderationAction);
        return new ModerationActionDTO(moderationAction);
    }

    @Override
    public ModerationActionDTO updateModerationAction(Long id, ModerationActionDTO moderationActionDTO) {
        ModerationAction moderationAction = moderationActionRepository.findById(id).orElse(null);
        if (moderationAction != null) {
            moderationAction.setAction_id(moderationActionDTO.getAction_id());
            moderationAction.setAction_type(moderationActionDTO.getAction_type());
            moderationAction.setAction_date(moderationActionDTO.getAction_date());
            moderationAction.setComment(moderationActionDTO.getComment());

            moderationAction = moderationActionRepository.save(moderationAction);
        }
        return new ModerationActionDTO(moderationAction);
    }

    @Override
    public void deleteModerationAction(Long id) {
        moderationActionRepository.deleteById(id);
    }
}




