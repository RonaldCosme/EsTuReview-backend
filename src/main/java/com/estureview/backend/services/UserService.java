package com.estureview.backend.services;


import com.estureview.backend.entities.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> listAllUsers();
    User findUserById(Long id);
    void deleteUser(Long id);
    User updateUser(User user);
}