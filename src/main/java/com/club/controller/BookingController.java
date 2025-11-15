package com.club.controller;

import com.club.dto.BookingDto;
import com.club.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping
    public ResponseEntity<List<BookingDto>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDto> getBookingById(@PathVariable Long id) {
        BookingDto booking = bookingService.getBookingById(id);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto) {
        return ResponseEntity.ok(bookingService.createBooking(bookingDto));
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<BookingDto> cancelBooking(@PathVariable Long id) {
        BookingDto booking = bookingService.cancelBooking(id);
        return booking != null ? ResponseEntity.ok(booking) : ResponseEntity.notFound().build();
    }
}