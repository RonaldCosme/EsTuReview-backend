package com.estureview.backend.serviceimpl;


import com.estureview.backend.dtos.DTOUser;
import com.estureview.backend.entities.AuthorityName;
import com.estureview.backend.entities.User;
import com.estureview.backend.exceptions.IncompleteDataException;
import com.estureview.backend.exceptions.KeyRepeatedDataException;
import com.estureview.backend.exceptions.ResourceNotFoundException;
import com.estureview.backend.repositories.AuthorityRepository;
import com.estureview.backend.repositories.UserRepository;
import com.estureview.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public User findById(Long id) {
        User userFound = userRepository.findById(id).orElse(null);
        if (userFound == null) {
            throw new ResourceNotFoundException("There are no User with the id: "+String.valueOf(id));
        }
        return userFound;
    }

    @Override
    public User register(DTOUser user) {

        if (user.getUserName().length()>4 && user.getPassword().length()>4) {

            User userFound = userRepository.findByUserName(user.getUserName());
            if (userFound != null) {
                throw new KeyRepeatedDataException("User name can not be duplicated");
            };

            User newUser = new User();
            newUser.setUserName(user.getUserName());
            newUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            newUser.setEnabled(true);
            newUser.setPasswordLastUpdate(new Date());
            AuthorityName authorityName=AuthorityName.ROLE_ALUMNO;
            if (user.getType().equals("ROLE_ALUMNO")) authorityName= AuthorityName.ROLE_ALUMNO;
            if (user.getType().equals("ROLE_PROFESSOR")) authorityName= AuthorityName.ROLE_PROFESSOR;
            if (user.getType().equals("ROLE_ADMIN")) authorityName= AuthorityName.ROLE_ADMIN;
            newUser.setAuthorities(
                    List.of(
                            authorityRepository.findByName(authorityName)
                    )
            );

            return userRepository.save(newUser);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }

    @Override
    public User changePassword(DTOUser user) {
        if (user.getUserName().length()>4 && user.getPassword().length()>4) {

            User userFound = userRepository.findByUserName(user.getUserName());
            if (userFound == null) {
                throw new ResourceNotFoundException("User name can not be found");
            };

            userFound.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            userFound.setPasswordLastUpdate(new Date());
            return userRepository.save(userFound);
        } else {
            throw new IncompleteDataException("User name and password length can not be less than 4 characters");
        }
    }
}

//un usuario no puede tener la contraseña o nombre de usuario menor que 4 digitos
