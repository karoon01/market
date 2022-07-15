package com.yosypchuk.market.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class AuthRequestDTO {
    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}
