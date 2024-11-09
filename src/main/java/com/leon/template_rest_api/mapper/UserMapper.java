package com.leon.template_rest_api.mapper;

import com.leon.template_rest_api.dto.request.UserRequestDTO;
import com.leon.template_rest_api.entity.user.UserEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserRequestDTO toUserRequestDTO(UserEntity userEntity);
    UserEntity toUserEntity(UserRequestDTO userRequestDTO);

}
