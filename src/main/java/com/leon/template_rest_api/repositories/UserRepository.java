package com.leon.template_rest_api.repositories;


import com.leon.template_rest_api.entity.user.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Page<UserEntity> findByUserName(String userName, Pageable pageable);
}