package com.webgoat.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class AuthController {

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        // Validate username and password (replace with actual validation logic)
        if ("user".equals(username) && "password".equals(password)) {
            return JwtUtil.generateToken(username);
        } else {
            return "Invalid credentials";
        }
    }
}