package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.ModerationActionDTO;
import com.estureview.backend.entities.ModerationAction;
import com.estureview.backend.repositories.ModerationActionRepository;
import com.estureview.backend.services.ModerationActionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModerationActionServiceImpl implements ModerationActionService {

    @Autowired
    private ModerationActionRepository moderationActionRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<ModerationActionDTO> findAll() {
        return moderationActionRepository.findAll()
                .stream()
                .map(moderationAction -> modelMapper.map(moderationAction, ModerationActionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ModerationActionDTO findById(Integer id) {
        ModerationAction moderationAction = moderationActionRepository.findById(id).orElse(null);
        return moderationAction != null ? modelMapper.map(moderationAction, ModerationActionDTO.class) : null;
    }

    @Override
    public ModerationActionDTO save(ModerationActionDTO moderationActionDTO) {
        ModerationAction moderationAction = modelMapper.map(moderationActionDTO, ModerationAction.class);
        moderationAction = moderationActionRepository.save(moderationAction);
        return modelMapper.map(moderationAction, ModerationActionDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        moderationActionRepository.deleteById(id);
    }
}

