package com.club.controller;

import com.club.dto.TournamentDto;
import com.club.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService tournamentService;

    @GetMapping
    public ResponseEntity<List<TournamentDto>> getAllTournaments() {
        return ResponseEntity.ok(tournamentService.getAllTournaments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentDto> getTournamentById(@PathVariable Long id) {
        TournamentDto tournament = tournamentService.getTournamentById(id);
        return tournament != null ? ResponseEntity.ok(tournament) : ResponseEntity.notFound().build();
    }

    @GetMapping("/published")
    public ResponseEntity<List<TournamentDto>> getPublishedTournaments() {
        return ResponseEntity.ok(tournamentService.getPublishedTournaments());
    }

    @PostMapping
    public ResponseEntity<TournamentDto> createTournament(@RequestBody TournamentDto tournamentDto) {
        return ResponseEntity.ok(tournamentService.createTournament(tournamentDto));
    }

    @PutMapping("/{id}/publish")
    public ResponseEntity<TournamentDto> publishTournament(@PathVariable Long id) {
        TournamentDto tournament = tournamentService.publishTournament(id);
        return tournament != null ? ResponseEntity.ok(tournament) : ResponseEntity.notFound().build();
    }
}