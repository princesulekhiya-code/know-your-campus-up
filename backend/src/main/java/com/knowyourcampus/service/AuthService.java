package com.knowyourcampus.service;

import com.knowyourcampus.dto.LoginRequest;
import com.knowyourcampus.dto.LoginResponse;
import com.knowyourcampus.entity.AdminUser;
import com.knowyourcampus.repository.AdminUserRepository;
import com.knowyourcampus.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

        AdminUser adminUser = adminUserRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtUtil.generateToken(adminUser.getEmail());

        return new LoginResponse(token, adminUser.getEmail(), adminUser.getFullName(), adminUser.getRole());
    }

    public AdminUser createAdmin(AdminUser adminUser) {
        adminUser.setPassword(passwordEncoder.encode(adminUser.getPassword()));
        return adminUserRepository.save(adminUser);
    }
}
