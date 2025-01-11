package com.samdevweb.monitoramento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.samdevweb.monitoramento.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

    long countByActive(boolean active);
    
}
