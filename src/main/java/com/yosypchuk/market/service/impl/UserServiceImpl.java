package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityAlreadyExistException;
import com.yosypchuk.market.mapper.UserMapper;
import com.yosypchuk.market.model.dto.UserDTO;
import com.yosypchuk.market.model.entity.Role;
import com.yosypchuk.market.model.entity.User;
import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.repository.UserRepository;
import com.yosypchuk.market.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        String email = userDTO.getEmail();
        String password = userDTO.getPassword();

        Optional<User> possibleUser = userRepository.findByEmail(email);

        if(possibleUser.isPresent()){
            log.warn("User with email: {} is already exist", email);
            throw new EntityAlreadyExistException("User is already exist");
        }

        User user = UserMapper.INSTANCE.mapUser(userDTO);
        user.setPassword(passwordEncoder.encode(password));
        user.setRole(Role.USER);

        userRepository.save(user);

        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDTO getUserById(Long id) {
        log.info("Get user by id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User is not found!"));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        log.info("Trying to get user by email: {} ", email);
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("User is not found!"));
        return UserMapper.INSTANCE.mapUserDto(user);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        log.info("Delete user with id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User is not found!"));
        userRepository.delete(user);
    }

    @Transactional
    @Override
    public UserDTO update(Long id, UserDTO userDTO) {
        log.info("Update user with id: {}", id);
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User is not found"));
        User updatedUser = User.builder()
                .id(id)
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .phoneNumber(userDTO.getPhoneNumber())
                .role(user.getRole())
                .build();

        userRepository.save(updatedUser);

        return UserMapper.INSTANCE.mapUserDto(updatedUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        log.info("Get all users");
        return userRepository.findAll()
                .stream()
                .map(UserMapper.INSTANCE::mapUserDto)
                .collect(Collectors.toList());
    }
}
