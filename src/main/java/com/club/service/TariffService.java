package com.club.service;

import com.club.domain.Tariff;
import com.club.dto.TariffDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TariffService {
    private final Map<Long, Tariff> tariffs = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public TariffService() {
        // Mock тарифы
        addTariff("Базовый", new BigDecimal("200.00"), "Стандартная конфигурация");
        addTariff("Премиум", new BigDecimal("350.00"), "Мощная игровая конфигурация");
        addTariff("Ночной", new BigDecimal("150.00"), "Специальный ночной тариф");
    }

    public List<TariffDto> getAllTariffs() {
        return tariffs.values().stream()
                .map(this::convertToDto)
                .toList();
    }

    public TariffDto getTariffById(Long id) {
        Tariff tariff = tariffs.get(id);
        return tariff != null ? convertToDto(tariff) : null;
    }

    public TariffDto createTariff(TariffDto tariffDto) {
        return addTariff(tariffDto.getName(), tariffDto.getPricePerHour(), tariffDto.getDescription());
    }

    private TariffDto addTariff(String name, BigDecimal price, String description) {
        Tariff tariff = new Tariff();
        tariff.setId(idCounter.getAndIncrement());
        tariff.setName(name);
        tariff.setPricePerHour(price);
        tariff.setDescription(description);
        tariffs.put(tariff.getId(), tariff);
        return convertToDto(tariff);
    }

    private TariffDto convertToDto(Tariff tariff) {
        TariffDto dto = new TariffDto();
        dto.setId(tariff.getId());
        dto.setName(tariff.getName());
        dto.setPricePerHour(tariff.getPricePerHour());
        dto.setDescription(tariff.getDescription());
        return dto;
    }
}