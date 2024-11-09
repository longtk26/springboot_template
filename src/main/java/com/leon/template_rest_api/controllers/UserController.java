package com.leon.template_rest_api.controllers;

import com.leon.template_rest_api.dto.request.UserRequestDTO;
import com.leon.template_rest_api.dto.response.UserResponseDTO;
import com.leon.template_rest_api.entity.user.UserEntity;
import com.leon.template_rest_api.enums.ResponseCode;
import com.leon.template_rest_api.infrastructure.response.SuccessResponse;
import com.leon.template_rest_api.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    @Operation(summary = "Get users by page.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200", description = "Get users",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Page.class)
                            )
                    }),
    })
    @GetMapping("/users")
    public ResponseEntity getAllUsers(
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);

        Page<UserEntity> data = this.userService.findAllUsers(pageable);

        return new SuccessResponse<>(
                "Get users success!",
                ResponseCode.SUCCESS.code,
                data
        ).send();
    }

    @GetMapping("/user")
    public  ResponseEntity getUser(@AuthenticationPrincipal Jwt jwt) {
        return new SuccessResponse<>(
                "Get users success!",
                ResponseCode.SUCCESS.code,
                jwt.getSubject()
        ).send();
    }

    @GetMapping("/searchPage")
    public ResponseEntity searchPageUserName(
            @RequestParam String name,
            @RequestParam int page,
            @RequestParam int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "desc") String direction
    ) {
        Sort.Direction sortDirection = direction.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sortBy = Sort.by(sortDirection, sort);
        Pageable pageable = PageRequest.of(page, size, sortBy);

        Page<UserEntity> data = this.userService.findByUserName(name, pageable);

        return new SuccessResponse<>(
                "Search users success!",
                ResponseCode.SUCCESS.code,
                data
        ).send();
    }

    @PostMapping("/create")
    public ResponseEntity createUser(@Valid @RequestBody UserRequestDTO userBody) {
        this.userService.createUser(userBody);

        return new SuccessResponse<>(
                "Create users success!",
                ResponseCode.SUCCESS.code,
                "ok"
        ).send();
    }
}
