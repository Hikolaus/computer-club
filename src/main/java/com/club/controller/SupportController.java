package com.club.controller;

import com.club.dto.SupportTicketDto;
import com.club.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/support")
public class SupportController {

    @Autowired
    private SupportService supportService;

    @GetMapping
    public ResponseEntity<List<SupportTicketDto>> getAllTickets() {
        return ResponseEntity.ok(supportService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupportTicketDto> getTicketById(@PathVariable Long id) {
        SupportTicketDto ticket = supportService.getTicketById(id);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<SupportTicketDto> createTicket(@RequestBody SupportTicketDto ticketDto) {
        return ResponseEntity.ok(supportService.createTicket(ticketDto));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<SupportTicketDto> updateTicketStatus(
            @PathVariable Long id,
            @RequestParam String status) {
        SupportTicketDto ticket = supportService.updateTicketStatus(id, status);
        return ticket != null ? ResponseEntity.ok(ticket) : ResponseEntity.notFound().build();
    }
}