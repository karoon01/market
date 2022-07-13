package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.entity.User;
import com.yosypchuk.market.exception.UserNotFoundException;
import com.yosypchuk.market.repository.UserRepository;
import com.yosypchuk.market.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(Long id) {
        log.info("Trying to get user by id: {} ", id);
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Cannot get user with id: " + id));
    }

    @Override
    public User getUserByEmail(String email){
        log.info("Trying to get user by email: {} ", email);
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Cannot get user with email: " + email));
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
        log.info("User {} {} have been successfully saved!", user.getFirstName(), user.getLastName());
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
        log.info("User {} {} have been successfully deleted!", user.getFirstName(), user.getLastName());
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
