package com.club.service;

import com.club.domain.Tournament;
import com.club.dto.TournamentDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TournamentService {
    private final Map<Long, Tournament> tournaments = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public TournamentService() {
        // Mock турниры
        addTournament("CS2 Championship", "Кубок по Counter-Strike 2",
                LocalDateTime.now().plusDays(7), new BigDecimal("50000.00"));
        addTournament("Dota 2 Weekly", "Еженедельный турнир по Dota 2",
                LocalDateTime.now().plusDays(3), new BigDecimal("15000.00"));
        addTournament("Valorant Open Cup", "Открытый кубок по Valorant",
                LocalDateTime.now().plusDays(14), new BigDecimal("30000.00"));
    }

    public List<TournamentDto> getAllTournaments() {
        return tournaments.values().stream()
                .map(this::convertToDto)
                .toList();
    }

    public TournamentDto getTournamentById(Long id) {
        Tournament tournament = tournaments.get(id);
        return tournament != null ? convertToDto(tournament) : null;
    }

    public List<TournamentDto> getPublishedTournaments() {
        return tournaments.values().stream()
                .filter(t -> "опубликован".equals(t.getStatus()))
                .map(this::convertToDto)
                .toList();
    }

    public TournamentDto createTournament(TournamentDto tournamentDto) {
        Tournament tournament = new Tournament();
        tournament.setId(idCounter.getAndIncrement());
        tournament.setTitle(tournamentDto.getTitle());
        tournament.setDescription(tournamentDto.getDescription());
        tournament.setDateTime(tournamentDto.getDateTime());
        tournament.setPrizeFund(tournamentDto.getPrizeFund());
        tournament.setStatus("черновик");

        tournaments.put(tournament.getId(), tournament);
        return convertToDto(tournament);
    }

    public TournamentDto publishTournament(Long id) {
        Tournament tournament = tournaments.get(id);
        if (tournament != null) {
            tournament.setStatus("опубликован");
            return convertToDto(tournament);
        }
        return null;
    }

    private TournamentDto addTournament(String title, String description,
                                        LocalDateTime dateTime, BigDecimal prizeFund) {
        Tournament tournament = new Tournament();
        tournament.setId(idCounter.getAndIncrement());
        tournament.setTitle(title);
        tournament.setDescription(description);
        tournament.setDateTime(dateTime);
        tournament.setPrizeFund(prizeFund);
        tournament.setStatus("опубликован");
        tournaments.put(tournament.getId(), tournament);
        return convertToDto(tournament);
    }

    private TournamentDto convertToDto(Tournament tournament) {
        TournamentDto dto = new TournamentDto();
        dto.setId(tournament.getId());
        dto.setTitle(tournament.getTitle());
        dto.setDescription(tournament.getDescription());
        dto.setDateTime(tournament.getDateTime());
        dto.setPrizeFund(tournament.getPrizeFund());
        dto.setStatus(tournament.getStatus());
        dto.setParticipantsCount(8); // Заглушка
        return dto;
    }
}