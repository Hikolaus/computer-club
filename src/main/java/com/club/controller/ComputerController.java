package com.club.controller;

import com.club.dto.ComputerDto;
import com.club.service.ComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/computers")
public class ComputerController {

    @Autowired
    private ComputerService computerService;

    @GetMapping
    public ResponseEntity<List<ComputerDto>> getAllComputers() {
        return ResponseEntity.ok(computerService.getAllComputers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComputerDto> getComputerById(@PathVariable Long id) {
        ComputerDto computer = computerService.getComputerById(id);
        return computer != null ? ResponseEntity.ok(computer) : ResponseEntity.notFound().build();
    }

    @GetMapping("/available")
    public ResponseEntity<List<ComputerDto>> getAvailableComputers() {
        return ResponseEntity.ok(computerService.getAvailableComputers());
    }
}