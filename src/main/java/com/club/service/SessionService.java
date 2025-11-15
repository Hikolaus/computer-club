package com.club.service;

import com.club.domain.Session;
import com.club.dto.SessionDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class SessionService {
    private final Map<Long, Session> sessions = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final ComputerService computerService;

    public SessionService(ComputerService computerService) {
        this.computerService = computerService;

        // Mock сеансы
        Session session = new Session();
        session.setId(idCounter.getAndIncrement());
        session.setBookingId(1L);
        session.setActualStart(LocalDateTime.now().minusHours(1));
        session.setActualEnd(LocalDateTime.now());
        session.setFinalCost(new BigDecimal("200.00"));
        sessions.put(session.getId(), session);
    }

    public List<SessionDto> getAllSessions() {
        return sessions.values().stream()
                .map(this::convertToDto)
                .toList();
    }

    public SessionDto getSessionById(Long id) {
        Session session = sessions.get(id);
        return session != null ? convertToDto(session) : null;
    }

    public List<SessionDto> getActiveSessions() {
        return sessions.values().stream()
                .filter(session -> session.getActualEnd() == null)
                .map(this::convertToDto)
                .toList();
    }

    private SessionDto convertToDto(Session session) {
        SessionDto dto = new SessionDto();
        dto.setId(session.getId());
        dto.setBookingId(session.getBookingId());
        dto.setActualStart(session.getActualStart());
        dto.setActualEnd(session.getActualEnd());
        dto.setFinalCost(session.getFinalCost());

        if (session.getDuration() != null) {
            dto.setDuration(session.getDuration().toString());
        }

        // Получаем имя компьютера через бронирование
        dto.setComputerName("PC-1"); // Заглушка

        return dto;
    }
}