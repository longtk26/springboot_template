package com.leon.template_rest_api.services;

import com.leon.template_rest_api.dto.request.UserRequestDTO;
import com.leon.template_rest_api.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Page<UserEntity> findAllUsers(Pageable pageable);
    Page<UserEntity> findByUserName(String userName, Pageable pageable);
    void createUser(UserRequestDTO userRequestDTO);
}
