package com.leon.template_rest_api.infrastructure.config.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.leon.template_rest_api.enums.ResponseCode;
import com.leon.template_rest_api.infrastructure.response.ErrorResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AuthenEntryConfig implements AuthenticationEntryPoint {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        ErrorResponse<String> errMessage = new ErrorResponse<>("Authenticate failure", ResponseCode.AUTH_FAILURE.code, "Unthorized access. Please authenticate.");

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getOutputStream().write(objectMapper.writeValueAsBytes(errMessage));
    }
}
