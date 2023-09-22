package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ModerationActionDTO;
import com.estureview.backend.entities.ModerationAction;
import com.estureview.backend.repositories.ModerationActionRepository;
import com.estureview.backend.services.ModerationActionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ModerationActionServiceImpl implements ModerationActionService {

    @Autowired
    private ModerationActionRepository moderationActionRepository;

    @Override
    public ModerationActionDTO createModerationAction(ModerationActionDTO moderationActionDTO) {
        ModerationAction moderationAction = new ModerationAction();
        BeanUtils.copyProperties(moderationActionDTO, moderationAction);
        moderationAction = moderationActionRepository.save(moderationAction);
        BeanUtils.copyProperties(moderationAction, moderationActionDTO);
        return moderationActionDTO;
    }

    @Override
    public List<ModerationActionDTO> listAllModerationActions() {
        List<ModerationAction> moderationActions = moderationActionRepository.findAll();
        List<ModerationActionDTO> moderationActionDTOs = new ArrayList<>();
        for (ModerationAction moderationAction : moderationActions) {
            ModerationActionDTO moderationActionDTO = new ModerationActionDTO();
            BeanUtils.copyProperties(moderationAction, moderationActionDTO);
            moderationActionDTOs.add(moderationActionDTO);
        }
        return moderationActionDTOs;
    }

    @Override
    public ModerationActionDTO findModerationActionById(Integer id) {
        Optional<ModerationAction> moderationActionOptional = moderationActionRepository.findById(id);
        if (moderationActionOptional.isPresent()) {
            ModerationActionDTO moderationActionDTO = new ModerationActionDTO();
            BeanUtils.copyProperties(moderationActionOptional.get(), moderationActionDTO);
            return moderationActionDTO;
        }
        return null;
    }

    @Override
    public void deleteModerationAction(Integer id) {
        moderationActionRepository.deleteById(id);
    }

    @Override
    public ModerationActionDTO updateModerationAction(ModerationActionDTO moderationActionDTO) {
        if (moderationActionDTO.getId() == null) {
            throw new IllegalArgumentException("El ID de la acción de moderación es necesario para actualizar");
        }
        ModerationAction moderationAction = new ModerationAction();
        BeanUtils.copyProperties(moderationActionDTO, moderationAction);
        moderationAction = moderationActionRepository.save(moderationAction);
        BeanUtils.copyProperties(moderationAction, moderationActionDTO);
        return moderationActionDTO;
    }
}