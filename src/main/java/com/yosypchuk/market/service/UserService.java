package com.yosypchuk.market.service;

import com.yosypchuk.market.model.dto.UserDTO;
import com.yosypchuk.market.model.entity.User;

import java.util.List;

public interface UserService {
    UserDTO registerUser(UserDTO userDTO);

    UserDTO getUserByEmail(String email);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    void delete(Long id);

    UserDTO update(Long id, UserDTO userDTO);

}