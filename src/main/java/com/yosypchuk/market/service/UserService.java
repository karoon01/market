package com.yosypchuk.market.service;

import com.yosypchuk.market.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User getUserById(Long id);

    User getUserByEmail(String email);

    void save(User user);

    void delete(User user);

    List<User> getAll();

}