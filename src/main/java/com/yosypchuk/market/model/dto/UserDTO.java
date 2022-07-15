package com.yosypchuk.market.model.dto;

import com.yosypchuk.market.model.entity.Role;
import com.yosypchuk.market.validation.PhoneNumber;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class UserDTO {
    private Long id;
    private Role role;

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    @PhoneNumber
    private String phoneNumber;
}
