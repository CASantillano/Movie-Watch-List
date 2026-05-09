package com.example.moviewatchlist.controller;

import com.example.moviewatchlist.dto.AuthResponseDTO;
import com.example.moviewatchlist.dto.LoginDTO;
import com.example.moviewatchlist.dto.RegistrationDTO;
import com.example.moviewatchlist.dto.UserDTO;
import com.example.moviewatchlist.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody RegistrationDTO req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(authService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO req) {
        return ResponseEntity.ok(authService.login(req));
    }
}
