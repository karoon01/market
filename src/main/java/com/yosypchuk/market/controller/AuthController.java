package com.yosypchuk.market.controller;

import com.yosypchuk.market.api.AuthApi;
import com.yosypchuk.market.config.security.jwt.JwtUtils;
import com.yosypchuk.market.model.dto.AuthRequestDTO;
import com.yosypchuk.market.model.dto.UserDTO;
import com.yosypchuk.market.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class AuthController implements AuthApi {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;

    @Override
    public UserDTO register(@RequestBody @Valid UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @Override
    public ResponseEntity<UserDTO> login(AuthRequestDTO request) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        String token = JwtUtils.generateToken(authentication);
        UserDTO userDTO = userService.getUserByEmail(request.getEmail());

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, token).body(userDTO);
    }
}
