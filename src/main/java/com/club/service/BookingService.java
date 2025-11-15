package com.club.service;

import com.club.domain.Booking;
import com.club.dto.BookingDto;
import org.springframework.stereotype.Service;
import java.util.*;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class BookingService {
    private final Map<Long, Booking> bookings = new HashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);
    private final ComputerService computerService;

    public BookingService(ComputerService computerService) {
        this.computerService = computerService;

        // Mock бронирования
        Booking booking = new Booking();
        booking.setId(idCounter.getAndIncrement());
        booking.setUserId(2L);
        booking.setComputerId(1L);
        booking.setStartTime(LocalDateTime.now().plusHours(1));
        booking.setEndTime(LocalDateTime.now().plusHours(3));
        booking.setStatus("активно");
        booking.setTotalCost(new BigDecimal("400.00"));
        bookings.put(booking.getId(), booking);
    }

    public List<BookingDto> getAllBookings() {
        return bookings.values().stream()
                .map(this::convertToDto)
                .toList();
    }

    public BookingDto getBookingById(Long id) {
        Booking booking = bookings.get(id);
        return booking != null ? convertToDto(booking) : null;
    }

    public BookingDto createBooking(BookingDto bookingDto) {
        Booking booking = new Booking();
        booking.setId(idCounter.getAndIncrement());
        booking.setUserId(bookingDto.getUserId());
        booking.setComputerId(bookingDto.getComputerId());
        booking.setStartTime(bookingDto.getStartTime());
        booking.setEndTime(bookingDto.getEndTime());
        booking.setStatus("активно");
        booking.setTotalCost(bookingDto.getTotalCost());

        bookings.put(booking.getId(), booking);
        return convertToDto(booking);
    }

    public BookingDto cancelBooking(Long id) {
        Booking booking = bookings.get(id);
        if (booking != null) {
            booking.setStatus("отменено");
            return convertToDto(booking);
        }
        return null;
    }

    private BookingDto convertToDto(Booking booking) {
        BookingDto dto = new BookingDto();
        dto.setId(booking.getId());
        dto.setUserId(booking.getUserId());
        dto.setComputerId(booking.getComputerId());
        dto.setStartTime(booking.getStartTime());
        dto.setEndTime(booking.getEndTime());
        dto.setStatus(booking.getStatus());
        dto.setTotalCost(booking.getTotalCost());

        // Получаем имя компьютера
        var computerDto = computerService.getComputerById(booking.getComputerId());
        if (computerDto != null) {
            dto.setComputerName(computerDto.getName());
        }

        return dto;
    }
}