package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.UserAppDTO;
import com.estureview.backend.entities.UserApp;
import com.estureview.backend.repositories.UserAppRepository;
import com.estureview.backend.services.UserAppService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserAppServiceImpl implements UserAppService {

    @Autowired
    private UserAppRepository userAppRepository;

    @Override
    public UserAppDTO createUserApp(UserAppDTO userAppDTO) {
        UserApp userApp = new UserApp();
        BeanUtils.copyProperties(userAppDTO, userApp);
        userApp = userAppRepository.save(userApp);
        BeanUtils.copyProperties(userApp, userAppDTO);
        return userAppDTO;
    }

    @Override
    public List<UserAppDTO> listAllUserApps() {
        List<UserApp> userApps = userAppRepository.findAll();
        List<UserAppDTO> userAppDTOs = new ArrayList<>();
        for (UserApp userApp : userApps) {
            UserAppDTO userAppDTO = new UserAppDTO();
            BeanUtils.copyProperties(userApp, userAppDTO);
            userAppDTOs.add(userAppDTO);
        }
        return userAppDTOs;
    }

    @Override
    public UserAppDTO findUserAppById(Integer id) {
        Optional<UserApp> userAppOptional = userAppRepository.findById(id);
        if (userAppOptional.isPresent()) {
            UserAppDTO userAppDTO = new UserAppDTO();
            BeanUtils.copyProperties(userAppOptional.get(), userAppDTO);
            return userAppDTO;
        }
        return null;
    }

    @Override
    public void deleteUserApp(Integer id) {
        userAppRepository.deleteById(id);
    }

    @Override
    public UserAppDTO updateUserApp(UserAppDTO userAppDTO) {
        if (userAppDTO.getId() == null) {
            throw new IllegalArgumentException("El ID del usuario es necesario para actualizar");
        }
        UserApp userApp = new UserApp();
        BeanUtils.copyProperties(userAppDTO, userApp);
        userApp = userAppRepository.save(userApp);
        BeanUtils.copyProperties(userApp, userAppDTO);
        return userAppDTO;
    }
}
