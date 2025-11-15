package com.club.service;

import com.club.domain.Computer;
import com.club.domain.ComputerSpecs;
import com.club.domain.Tariff;
import com.club.dto.ComputerDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ComputerService {
    private final Map<Long, Computer> computers = new HashMap<>();
    private final Map<Long, ComputerSpecs> specs = new HashMap<>();
    private final Map<Long, Tariff> tariffs = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public ComputerService() {
        // Mock тарифы
        Tariff basic = new Tariff();
        basic.setId(idCounter.getAndIncrement());
        basic.setName("Базовый");
        basic.setPricePerHour(new BigDecimal("200.00"));
        tariffs.put(basic.getId(), basic);

        Tariff premium = new Tariff();
        premium.setId(idCounter.getAndIncrement());
        premium.setName("Премиум");
        premium.setPricePerHour(new BigDecimal("350.00"));
        tariffs.put(premium.getId(), premium);

        // Mock конфигурации
        ComputerSpecs spec1 = new ComputerSpecs();
        spec1.setId(idCounter.getAndIncrement());
        spec1.setCpu("Intel Core i5-12400F");
        spec1.setGpu("NVIDIA RTX 3060");
        spec1.setRam(16);
        spec1.setTariffId(basic.getId());
        specs.put(spec1.getId(), spec1);

        ComputerSpecs spec2 = new ComputerSpecs();
        spec2.setId(idCounter.getAndIncrement());
        spec2.setCpu("AMD Ryzen 7 5800X");
        spec2.setGpu("NVIDIA RTX 4070");
        spec2.setRam(32);
        spec2.setTariffId(premium.getId());
        specs.put(spec2.getId(), spec2);

        // Mock компьютеры
        for (int i = 1; i <= 10; i++) {
            Computer computer = new Computer();
            computer.setId(idCounter.getAndIncrement());
            computer.setName("PC-" + i);
            computer.setSpecId(i % 2 == 0 ? spec2.getId() : spec1.getId());
            computer.setStatus(i <= 8 ? "свободен" : "занят");
            computers.put(computer.getId(), computer);
        }
    }

    public List<ComputerDto> getAllComputers() {
        return computers.values().stream()
                .map(this::convertToDto)
                .toList();
    }

    public ComputerDto getComputerById(Long id) {
        Computer computer = computers.get(id);
        return computer != null ? convertToDto(computer) : null;
    }

    public List<ComputerDto> getAvailableComputers() {
        return computers.values().stream()
                .filter(comp -> "свободен".equals(comp.getStatus()))
                .map(this::convertToDto)
                .toList();
    }

    private ComputerDto convertToDto(Computer computer) {
        ComputerDto dto = new ComputerDto();
        dto.setId(computer.getId());
        dto.setName(computer.getName());
        dto.setStatus(computer.getStatus());

        ComputerSpecs spec = specs.get(computer.getSpecId());
        if (spec != null) {
            dto.setCpu(spec.getCpu());
            dto.setGpu(spec.getGpu());
            dto.setRam(spec.getRam());

            Tariff tariff = tariffs.get(spec.getTariffId());
            if (tariff != null) {
                dto.setPricePerHour(tariff.getPricePerHour());
            }
        }

        return dto;
    }
}