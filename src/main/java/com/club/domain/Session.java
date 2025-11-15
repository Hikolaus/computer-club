package com.club.domain;

import java.time.LocalDateTime;
import java.time.Duration;
import java.math.BigDecimal;

public class Session {
    private Long id;
    private Long bookingId;
    private LocalDateTime actualStart;
    private LocalDateTime actualEnd;
    private Duration duration;
    private BigDecimal finalCost;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public LocalDateTime getActualStart() { return actualStart; }
    public void setActualStart(LocalDateTime actualStart) { this.actualStart = actualStart; }

    public LocalDateTime getActualEnd() { return actualEnd; }
    public void setActualEnd(LocalDateTime actualEnd) { this.actualEnd = actualEnd; }

    public Duration getDuration() { return duration; }
    public void setDuration(Duration duration) { this.duration = duration; }

    public BigDecimal getFinalCost() { return finalCost; }
    public void setFinalCost(BigDecimal finalCost) { this.finalCost = finalCost; }
}