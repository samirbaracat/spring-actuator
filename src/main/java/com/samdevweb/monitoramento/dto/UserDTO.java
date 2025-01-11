package com.samdevweb.monitoramento.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserDTO {
    
    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotEmpty
    private String phoneNumber;

    @NotNull
    private LocalDate birthday;
    
    private boolean active;
}
