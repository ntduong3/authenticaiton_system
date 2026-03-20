package com.example.authsystem.service;

import com.example.authsystem.dto.UserRegistrationDto;
import com.example.authsystem.model.AppUser;

public interface UserService {
    AppUser register(UserRegistrationDto registrationDto);

    boolean existsByEmail(String email);
}
