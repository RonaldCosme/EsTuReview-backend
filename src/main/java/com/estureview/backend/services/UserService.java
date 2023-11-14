package com.estureview.backend.services;

import com.estureview.backend.entities.User;
import com.estureview.backend.dtos.DTOUser;
public interface UserService {

    public User findById(Long id);

    public User register(DTOUser user);

    public User changePassword(DTOUser user);
}
