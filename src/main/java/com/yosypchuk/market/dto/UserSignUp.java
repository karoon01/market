package com.yosypchuk.market.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Size;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class UserSignUp {
    @Size(min = 10, message = "Email should have at least 10 characters")
    @Size(max = 50, message = "Email should have not more than 50 characters")
    private String email;

    @Size(min = 8, message = "Password should have at least 8 characters")
    @Size(max = 32, message = "Password should have not more than 32 characters")
    private String password;
}
