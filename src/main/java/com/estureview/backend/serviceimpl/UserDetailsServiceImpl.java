package com.estureview.backend.serviceimpl;

import com.estureview.backend.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import com.estureview.backend.repositories.UserRepository;
import com.estureview.backend.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (user !=null) {
            return new SecurityUser(user);
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }
}
