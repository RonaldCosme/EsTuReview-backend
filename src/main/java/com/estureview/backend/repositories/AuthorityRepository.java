package com.estureview.backend.repositories;

import com.estureview.backend.entities.Authority;
import com.estureview.backend.entities.AuthorityName;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority,Long> {
    public Authority findByName(AuthorityName name);
}
