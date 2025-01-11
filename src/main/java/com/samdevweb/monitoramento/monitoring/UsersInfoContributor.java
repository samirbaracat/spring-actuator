package com.samdevweb.monitoramento.monitoring;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.stereotype.Component;

import com.samdevweb.monitoramento.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.InfoContributor;

@Component
@RequiredArgsConstructor
public class UsersInfoContributor implements InfoContributor {

    private final UserRepository userRepository;

    @Override
    public void contribute(Builder builder) {
        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("total", userRepository.count());
        userDetails.put("actives", userRepository.countByActive(true));
        userDetails.put("inactives", userRepository.countByActive(false));
        builder.withDetail("userDetails", userDetails);
    }
    
}
