package com.example.socialMediaBE.service.impl;

import java.time.LocalDateTime;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.socialMediaBE.common.ErrorCode;
import com.example.socialMediaBE.dto.auth.AuthResponse;
import com.example.socialMediaBE.dto.auth.RegisterRequest;
import com.example.socialMediaBE.entity.User;
import com.example.socialMediaBE.repository.AuthRepository;
import com.example.socialMediaBE.security.JwtUtil;
import com.example.socialMediaBE.service.AuthService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService  {

    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if(authRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException(ErrorCode.USERNAME_ALREADY_EXISTS.getMessage());
        }

        if(authRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException(ErrorCode.EMAIL_ALREADY_EXISTS.getMessage());
        }

        User user = User.builder().
                username(request.getUsername()).
                email(request.getEmail()).
                displayName(request.getDisplayName()).
                password(passwordEncoder.encode(request.getPassword())).
                status(1L).
                createdAt(LocalDateTime.now()).
                updatedAt(LocalDateTime.now()).
                lastLogin(LocalDateTime.now()).
                build();

        User savedUser = authRepository.save(user);

        String accessToken = jwtUtil.generateToken(savedUser.getUsername());

        return AuthResponse.builder()
                .accessToken(accessToken)
                .userId(savedUser.getId())
                .username(savedUser.getUsername())
                .email(savedUser.getEmail())
                .displayName(savedUser.getDisplayName())
                .build();
    }
}
