package com.leon.template_rest_api.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRequestDTO {
    @NotNull(message = "userName can not be null")
    @NotEmpty(message = "userName can not be empty")
    private String userName;

    @NotNull(message = "email can not be null")
    @Email(message = "email is invalid")
    private String email;

    private String address;

    @NotNull(message = "email can not be null")
    private Integer age;
}
