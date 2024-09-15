package com.leon.template_rest_api.dto.response;

import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String userName;

    public UserResponseDTO() {

    }

    public UserResponseDTO(Long id, String userName) {
        this.id = id;
        this.userName = userName;
    }
}
