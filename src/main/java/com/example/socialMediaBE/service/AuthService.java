package com.example.socialMediaBE.service;

import com.example.socialMediaBE.dto.auth.AuthResponse;
import com.example.socialMediaBE.dto.auth.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
}
