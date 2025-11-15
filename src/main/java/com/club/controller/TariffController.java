package com.club.controller;

import com.club.dto.TariffDto;
import com.club.service.TariffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tariffs")
public class TariffController {

    @Autowired
    private TariffService tariffService;

    @GetMapping
    public ResponseEntity<List<TariffDto>> getAllTariffs() {
        return ResponseEntity.ok(tariffService.getAllTariffs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TariffDto> getTariffById(@PathVariable Long id) {
        TariffDto tariff = tariffService.getTariffById(id);
        return tariff != null ? ResponseEntity.ok(tariff) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<TariffDto> createTariff(@RequestBody TariffDto tariffDto) {
        return ResponseEntity.ok(tariffService.createTariff(tariffDto));
    }
}