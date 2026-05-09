package com.example.moviewatchlist.service;

import com.example.moviewatchlist.dto.AuthResponseDTO;
import com.example.moviewatchlist.dto.LoginDTO;
import com.example.moviewatchlist.dto.RegistrationDTO;
import com.example.moviewatchlist.dto.UserDTO;
import com.example.moviewatchlist.entity.User;
import com.example.moviewatchlist.repository.UserRepository;
import com.example.moviewatchlist.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtUtil jwtUtil;

    public UserDTO register(RegistrationDTO req) {
        if (userRepository.existsByEmail(req.getEmail())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Email already registered");
        }
        User user = new User();
        user.setUsername(req.getUsername());
        user.setEmail(req.getEmail());
        user.setPassword(passwordEncoder.encode(req.getPassword()));
        userRepository.save(user);

        return new UserDTO(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        );
    }

    public AuthResponseDTO login(LoginDTO req) {
        User user = userRepository.findByEmail(req.getEmail())
                .orElseThrow(()->new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));

        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getId(), user.getEmail());
        return new AuthResponseDTO(token);
    }
}
