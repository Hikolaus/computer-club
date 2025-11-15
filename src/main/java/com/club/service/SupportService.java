package com.club.service;

import com.club.domain.SupportTicket;
import com.club.dto.SupportTicketDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SupportService {
    private final Map<Long, SupportTicket> tickets = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final ComputerService computerService;

    public SupportService(ComputerService computerService) {
        this.computerService = computerService;

        // Mock заявки
        SupportTicket ticket = new SupportTicket();
        ticket.setId(idCounter.getAndIncrement());
        ticket.setUserId(2L);
        ticket.setComputerId(1L);
        ticket.setCategoryId(1L);
        ticket.setDescription("Не работает мышь");
        ticket.setStatus("новое");
        ticket.setCreatedAt(LocalDateTime.now().minusHours(1));
        tickets.put(ticket.getId(), ticket);
    }

    public List<SupportTicketDto> getAllTickets() {
        return tickets.values().stream()
                .map(this::convertToDto)
                .toList();
    }

    public SupportTicketDto getTicketById(Long id) {
        SupportTicket ticket = tickets.get(id);
        return ticket != null ? convertToDto(ticket) : null;
    }

    public SupportTicketDto createTicket(SupportTicketDto ticketDto) {
        SupportTicket ticket = new SupportTicket();
        ticket.setId(idCounter.getAndIncrement());
        ticket.setUserId(ticketDto.getUserId());
        ticket.setComputerId(ticketDto.getComputerId());
        ticket.setCategoryId(1L); // Заглушка
        ticket.setDescription(ticketDto.getDescription());
        ticket.setStatus("новое");
        ticket.setCreatedAt(LocalDateTime.now());

        tickets.put(ticket.getId(), ticket);
        return convertToDto(ticket);
    }

    public SupportTicketDto updateTicketStatus(Long id, String status) {
        SupportTicket ticket = tickets.get(id);
        if (ticket != null) {
            ticket.setStatus(status);
            if ("решено".equals(status)) {
                ticket.setResolvedAt(LocalDateTime.now());
            }
            return convertToDto(ticket);
        }
        return null;
    }

    private SupportTicketDto convertToDto(SupportTicket ticket) {
        SupportTicketDto dto = new SupportTicketDto();
        dto.setId(ticket.getId());
        dto.setUserId(ticket.getUserId());
        dto.setComputerId(ticket.getComputerId());
        dto.setDescription(ticket.getDescription());
        dto.setStatus(ticket.getStatus());
        dto.setCreatedAt(ticket.getCreatedAt());

        // Получаем имя компьютера
        var computerDto = computerService.getComputerById(ticket.getComputerId());
        if (computerDto != null) {
            dto.setComputerName(computerDto.getName());
        }

        dto.setCategoryName("Оборудование"); // Заглушка

        return dto;
    }
}