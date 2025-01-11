package com.samdevweb.monitoramento.controller;

import java.util.List;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.samdevweb.monitoramento.dto.UserDTO;
import com.samdevweb.monitoramento.dto.mapper.UserMapper;
import com.samdevweb.monitoramento.entity.User;
import com.samdevweb.monitoramento.repository.UserRepository;
import com.samdevweb.monitoramento.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        return userRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public User save(@Valid @RequestBody UserDTO userDTO) {
        return userRepository.save(UserMapper.toUser(userDTO));
    }

    @PutMapping("/{id}")
    public User update(@PathVariable String id, @Valid @RequestBody UserDTO userDTO) {
        return userService.update(id, UserMapper.toUser(userDTO));
    }

    @GetMapping("/{id}/state")
    public void changeState(@PathVariable String id) {
        userService.changeState(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable String id) {
        userRepository.deleteById(id);
    }
    
}
