package com.victor.commandexecutorservice.controller;

import com.victor.commandexecutorservice.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username) {
        String token = JwtUtil.generateToken(username);
        return ResponseEntity.ok(token);
    }
}