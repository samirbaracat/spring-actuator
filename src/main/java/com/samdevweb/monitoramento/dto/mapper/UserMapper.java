package com.samdevweb.monitoramento.dto.mapper;

import com.samdevweb.monitoramento.dto.UserDTO;
import com.samdevweb.monitoramento.entity.User;

public class UserMapper {

    public static User toUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPhoneNumber(userDTO.getPhoneNumber());
        user.setBirthday(userDTO.getBirthday());
        user.setActive(userDTO.isActive());
        return user;
    }
}
