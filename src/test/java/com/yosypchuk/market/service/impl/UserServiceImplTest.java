package com.yosypchuk.market.service.impl;

import com.yosypchuk.market.exception.EntityAlreadyExistException;
import com.yosypchuk.market.exception.EntityNotFoundException;
import com.yosypchuk.market.model.dto.UserDTO;
import com.yosypchuk.market.model.entity.User;
import com.yosypchuk.market.repository.UserRepository;
import com.yosypchuk.market.utils.test.TestUserDataUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

import static com.yosypchuk.market.utils.test.TestUserDataUtil.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl userService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private PasswordEncoder passwordEncoder;

    @Test
    void testRegisterUser() {
        //given
        User expectedUser = TestUserDataUtil.createUser();
        UserDTO userBody = TestUserDataUtil.createUserDto();

        when(userRepository.findByEmail(MOCK_EMAIL)).thenReturn(Optional.empty());
        when(userRepository.save(any())).thenReturn(expectedUser);

        //when
        UserDTO actualUser = userService.registerUser(userBody);

        //then
        assertEquals(passwordEncoder.encode(MOCK_PASSWORD), passwordEncoder.encode(actualUser.getPassword()));
        assertThat(actualUser, allOf(
                hasProperty("id", equalTo(expectedUser.getId())),
                hasProperty("firstName", equalTo(expectedUser.getFirstName())),
                hasProperty("lastName", equalTo(expectedUser.getLastName())),
                hasProperty("email", equalTo(expectedUser.getEmail())),
                hasProperty("role", equalTo(expectedUser.getRole()))
        ));
    }

    @Test
    void testRegisterUserThrowsExceptionIfUserAlreadyExist() {
        //given
        User user = TestUserDataUtil.createUser();
        UserDTO userBody = TestUserDataUtil.createUserDto();

        //when
        when(userRepository.findByEmail(MOCK_EMAIL)).thenReturn(Optional.of(user));

        //then
        assertThrows(EntityAlreadyExistException.class, () -> userService.registerUser(userBody));
    }

    @Test
    void testGetUserByEmail() {
        //given
        User expectedUser = TestUserDataUtil.createUser();
        when(userRepository.findByEmail(MOCK_EMAIL)).thenReturn(Optional.of(expectedUser));

        //when
        UserDTO actualUser = userService.getUserByEmail(MOCK_EMAIL);

        //then
        assertThat(actualUser, allOf(
                hasProperty("id", equalTo(expectedUser.getId())),
                hasProperty("firstName", equalTo(expectedUser.getFirstName())),
                hasProperty("lastName", equalTo(expectedUser.getLastName())),
                hasProperty("email", equalTo(expectedUser.getEmail())),
                hasProperty("role", equalTo(expectedUser.getRole()))
        ));
    }

    @Test
    void testGetUserByEmailThrowsExceptionIfUserDoesntExist() {
        //when
        when(userRepository.findByEmail(MOCK_EMAIL)).thenReturn(Optional.empty());

        //then
        assertThrows(EntityNotFoundException.class, () -> userService.getUserByEmail(MOCK_EMAIL));
    }

    @Test
    void testGetUserById() {
        //given
        User expectedUser = TestUserDataUtil.createUser();
        when(userRepository.findById(MOCK_ID)).thenReturn(Optional.of(expectedUser));

        //when
        UserDTO actualUser = userService.getUserById(MOCK_ID);

        //then
        assertThat(actualUser, allOf(
                hasProperty("id", equalTo(expectedUser.getId())),
                hasProperty("firstName", equalTo(expectedUser.getFirstName())),
                hasProperty("lastName", equalTo(expectedUser.getLastName())),
                hasProperty("email", equalTo(expectedUser.getEmail())),
                hasProperty("role", equalTo(expectedUser.getRole()))
        ));
    }

    @Test
    void testGetUserByIdThrowsExceptionIfUserDoesntExist() {
        //when
        when(userRepository.findById(MOCK_ID)).thenReturn(Optional.empty());

        //then
        assertThrows(EntityNotFoundException.class, () -> userService.getUserById(MOCK_ID));
    }

    @Test
    void testGetAllUsers() {
        //given
        User firstUser = TestUserDataUtil.createUser();
        User secondUser = TestUserDataUtil.createSecondUser();
        List<User> userList = List.of(firstUser, secondUser);

        when(userRepository.findAll()).thenReturn(userList);

        //when
        List<UserDTO> users = userService.getAllUsers();

        //then
        assertThat(users, hasSize(2));
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testDeleteUser() {
        //given
        User user = TestUserDataUtil.createUser();

        when(userRepository.findById(MOCK_ID)).thenReturn(Optional.of(user));
        doNothing().when(userRepository).delete(any());

        //when
        userService.delete(MOCK_ID);

        //then
        verify(userRepository, times(1)).delete(user);
    }

    @Test
    void testDeleteUserThrowsExceptionIfUserDoesntExist() {
        //when
        when(userRepository.findById(MOCK_ID)).thenReturn(Optional.empty());
        //then
        assertThrows(EntityNotFoundException.class, () -> userService.getUserById(MOCK_ID));
    }

    @Test
    void testUpdateTest() {
        //given
        User user = TestUserDataUtil.createUser();
        User expectedUser = TestUserDataUtil.createUpdatedUser();
        UserDTO updateBody = TestUserDataUtil.createUpdatedUserDto();

        when(userRepository.findById(MOCK_ID)).thenReturn(Optional.of(user));
        when(userRepository.save(any())).thenReturn(expectedUser);

        //when
        UserDTO updatedUser = userService.update(MOCK_ID, updateBody);

        //then
        assertThat(updatedUser, allOf(
                hasProperty("id", equalTo(expectedUser.getId())),
                hasProperty("firstName", equalTo(expectedUser.getFirstName())),
                hasProperty("lastName", equalTo(expectedUser.getLastName())),
                hasProperty("email", equalTo(expectedUser.getEmail())),
                hasProperty("role", equalTo(expectedUser.getRole()))
        ));
    }

    @Test
    void testUpdateTestThrowsExceptionIfUserDoesntExist() {
        //given
        UserDTO updateBody = TestUserDataUtil.createUpdatedUserDto();
        //when
        when(userRepository.findById(MOCK_ID)).thenReturn(Optional.empty());
        //then
        assertThrows(EntityNotFoundException.class, () -> userService.update(MOCK_ID, updateBody));
    }
}
