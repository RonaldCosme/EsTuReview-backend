package com.estureview.backend.services;

import com.estureview.backend.dtos.UserAppDTO;
import java.util.List;

public interface UserAppService {
    List<UserAppDTO> getAllUsers();
    UserAppDTO getUserById(Long id);
    UserAppDTO createUser(UserAppDTO userDTO);
    UserAppDTO updateUser(Long id, UserAppDTO userDTO);
    void deleteUser(Long id);
}