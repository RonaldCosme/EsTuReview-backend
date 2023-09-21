package com.estureview.backend.serviceimpl;

import com.estureview.backend.dtos.UserAppDTO;
import com.estureview.backend.entities.UserApp;
import com.estureview.backend.repositories.UserAppRepository;
import com.estureview.backend.services.UserAppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAppServiceImpl implements UserAppService {

    @Autowired
    private UserAppRepository userAppRepository;

    @Override
    public List<UserAppDTO> getAllUsers() {
        return userAppRepository.findAll().stream()
                .map(UserAppDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public UserAppDTO getUserById(Long id) {
        return userAppRepository.findById(id)
                .map(UserAppDTO::new)
                .orElse(null);  // Considera lanzar una excepción si el usuario no es encontrado
    }

    @Override
    public UserAppDTO createUser(UserAppDTO userDTO) {
        UserApp userApp = new UserApp();
        userApp.setName(userDTO.getName());
        userApp.setEmail(userDTO.getEmail());
        // ... establece los demás campos ...

        UserApp savedUserApp = userAppRepository.save(userApp);
        return new UserAppDTO(savedUserApp);
    }

    @Override
    public UserAppDTO updateUser(Long id, UserAppDTO userDTO) {
        // Aquí debes decidir cómo manejar la situación si el usuario no se encuentra en la DB
        UserApp existingUserApp = userAppRepository.findById(id).orElse(null);

        if (existingUserApp != null) {
            existingUserApp.setName(userDTO.getName());
            existingUserApp.setEmail(userDTO.getEmail());
            // ... actualiza los demás campos ...

            UserApp updatedUserApp = userAppRepository.save(existingUserApp);
            return new UserAppDTO(updatedUserApp);
        }
        return null;  // O considera lanzar una excepción si el usuario no es encontrado
    }

    @Override
    public void deleteUser(Long id) {
        userAppRepository.deleteById(id);
    }
}