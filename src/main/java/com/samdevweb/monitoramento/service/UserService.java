package com.samdevweb.monitoramento.service;

import org.springframework.stereotype.Service;

import com.samdevweb.monitoramento.entity.User;
import com.samdevweb.monitoramento.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.BeanUtils;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;

    public User update(String id, User user) {
        User databaseUser = userRepository.findById(id).orElseThrow();
        BeanUtils.copyProperties(user, databaseUser, "id", "createdAt", "updatedAt");
        return userRepository.save(user);
    }

    public void changeState(String id) {
        User databaseUser = userRepository.findById(id).orElseThrow();
        databaseUser.setActive(!databaseUser.isActive());
        userRepository.save(databaseUser);
    }

    public void deleteById(String id) {
        User databaseUser = userRepository.findById(id).orElseThrow();
        userRepository.delete(databaseUser);
    }
}
