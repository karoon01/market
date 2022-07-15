package com.yosypchuk.market.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class AuthRequestDTO {
    @NotBlank(message = "${user.email.not-blank}")
    @Email(message = "${user.email.not-valid}")
    private String email;

    @NotBlank(message = "${user.password.not-blank}")
    @Size(min = 6, message = "${user.password.length}")
    private String password;
}
