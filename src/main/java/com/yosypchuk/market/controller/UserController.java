package com.yosypchuk.market.controller;

import com.yosypchuk.market.api.UserApi;
import com.yosypchuk.market.model.dto.UserDTO;
import com.yosypchuk.market.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController implements UserApi {

    private final UserService userService;

    @Override
    public UserDTO getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @Override
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
