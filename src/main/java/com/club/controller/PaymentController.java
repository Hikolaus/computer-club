package com.club.controller;

import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    @PostMapping("/deposit")
    public ResponseEntity<Map<String, String>> deposit(@RequestBody Map<String, Object> paymentData) {
        // Заглушка для пополнения баланса
        return ResponseEntity.ok(Map.of("status", "success", "message", "Баланс пополнен"));
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Map<String, String>> withdraw(@RequestBody Map<String, Object> paymentData) {
        // Заглушка для списания средств
        return ResponseEntity.ok(Map.of("status", "success", "message", "Средства списаны"));
    }
}