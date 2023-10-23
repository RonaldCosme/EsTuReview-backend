package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.UserAppDTO;
import com.estureview.backend.entities.UserApp;
import com.estureview.backend.repositories.UserAppRepository;
import com.estureview.backend.security.CustomUserDetailsService;
import com.estureview.backend.services.UserAppService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAppServiceImpl implements UserAppService {

    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public List<UserAppDTO> findAll() {
        return userAppRepository.findAll()
                .stream()
                .map(userApp -> modelMapper.map(userApp, UserAppDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserAppDTO findById(Integer id) {
        UserApp userApp = userAppRepository.findById(id).orElse(null);
        return userApp != null ? modelMapper.map(userApp, UserAppDTO.class) : null;
    }

    @Override
    public UserAppDTO save(UserAppDTO userAppDTO) {
        UserApp userApp = modelMapper.map(userAppDTO, UserApp.class);
        userApp = userAppRepository.save(userApp);
        return modelMapper.map(userApp, UserAppDTO.class);
    }

    @Override
    public void deleteById(Integer id) {
        userAppRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {

        return customUserDetailsService.loadUserByUsername(username);
    }
}
