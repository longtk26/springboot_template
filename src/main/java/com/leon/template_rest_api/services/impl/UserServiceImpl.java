package com.leon.template_rest_api.services.impl;


import com.leon.template_rest_api.dto.request.UserRequestDTO;
import com.leon.template_rest_api.entity.user.UserEntity;
import com.leon.template_rest_api.exception.BadRequestException;
import com.leon.template_rest_api.mapper.UserMapper;
import com.leon.template_rest_api.repositories.UserRepository;
import com.leon.template_rest_api.services.UserService;
import com.leon.template_rest_api.validates.ObjectValidator;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final ObjectValidator<UserRequestDTO> userValidator;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Page<UserEntity> findAllUsers(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public Page<UserEntity> findByUserName(String userName, Pageable pageable) {
        return null;
    }

    @Override
    public void createUser(UserRequestDTO userRequestDTO) {
        logger.info("Validating.... {}", userRequestDTO);
        this.userValidator.validate(userRequestDTO);

        UserEntity userEntity = this.userMapper.toUserEntity(userRequestDTO);
        logger.info("Creating user.... {}", userEntity);
    }
}
