package com.estureview.backend.services;

import com.estureview.backend.dtos.UserAppDTO;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserAppService {
    List<UserAppDTO> findAll();
    UserAppDTO findById(Integer id);
    UserAppDTO save(UserAppDTO userAppDTO);
    void deleteById(Integer id);

    UserDetails loadUserByUsername(String username);
}