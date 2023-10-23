package com.estureview.backend.security;

import com.estureview.backend.entities.UserApp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserAppPrincipal implements UserDetails {

    private UserApp userApp;

    public UserAppPrincipal(UserApp userApp) {
        this.userApp = userApp;
    }

    public static UserAppPrincipal create(UserApp userApp) {
        return new UserAppPrincipal(userApp);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(userApp.getRole().name()));
    }



    @Override
    public String getPassword() {

        return userApp.getPassword();
    }

    @Override
    public String getUsername() {
        return userApp.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // Implementar los métodos restantes según tus necesidades y reglas de negocio
    // ...
}