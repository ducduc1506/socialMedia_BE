package com.example.socialMediaBE.controller;

import com.example.socialMediaBE.dto.BaseResponse;
import com.example.socialMediaBE.dto.auth.AuthResponse;
import com.example.socialMediaBE.dto.auth.RegisterRequest;
import com.example.socialMediaBE.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<BaseResponse<AuthResponse>> register(@Valid @RequestBody RegisterRequest request) {
       try {
        AuthResponse authResponse = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(BaseResponse.success("Đăng ký thành công", authResponse));
        
       } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(BaseResponse.error(400, e.getMessage()));
       }
    }
}
