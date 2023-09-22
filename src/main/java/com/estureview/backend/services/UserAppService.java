package com.estureview.backend.services;

import com.estureview.backend.dtos.UserAppDTO;
import java.util.List;

public interface UserAppService {

    UserAppDTO createUserApp(UserAppDTO userAppDTO);
    List<UserAppDTO> listAllUserApps();
    UserAppDTO findUserAppById(Integer id);
    void deleteUserApp(Integer id);
    UserAppDTO updateUserApp(UserAppDTO userAppDTO);
}