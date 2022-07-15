package com.yosypchuk.market.mapper;

import com.yosypchuk.market.model.dto.UserDTO;
import com.yosypchuk.market.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User mapUser(UserDTO userDTO);
    UserDTO mapUserDto(User user);
}
