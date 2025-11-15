package com.club.controller;

import com.club.dto.SessionDto;
import com.club.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping
    public ResponseEntity<List<SessionDto>> getAllSessions() {
        return ResponseEntity.ok(sessionService.getAllSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SessionDto> getSessionById(@PathVariable Long id) {
        SessionDto session = sessionService.getSessionById(id);
        return session != null ? ResponseEntity.ok(session) : ResponseEntity.notFound().build();
    }

    @GetMapping("/active")
    public ResponseEntity<List<SessionDto>> getActiveSessions() {
        return ResponseEntity.ok(sessionService.getActiveSessions());
    }
}