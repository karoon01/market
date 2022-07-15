package com.yosypchuk.market.controller;

import com.yosypchuk.market.api.AuthApi;
import com.yosypchuk.market.model.dto.AuthRequestDTO;
import com.yosypchuk.market.model.dto.UserDTO;
import com.yosypchuk.market.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class AuthController implements AuthApi {
    private final UserService userService;

    @Override
    public UserDTO register(@RequestBody @Valid UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @Override
    public ResponseEntity<UserDTO> login(AuthRequestDTO request) {
        return null;
    }
}
