package com.club.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
        // Заглушка для аутентификации
        return ResponseEntity.ok(Map.of("status", "success", "message", "Вход выполнен"));
    }

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody Map<String, String> userData) {
        // Заглушка для регистрации
        return ResponseEntity.ok(Map.of("status", "success", "message", "Пользователь зарегистрирован"));
    }
}