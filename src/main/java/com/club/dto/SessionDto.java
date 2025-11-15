package com.club.dto;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class SessionDto {
    private Long id;
    private Long bookingId;
    private LocalDateTime actualStart;
    private LocalDateTime actualEnd;
    private String duration;
    private BigDecimal finalCost;
    private String computerName;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBookingId() { return bookingId; }
    public void setBookingId(Long bookingId) { this.bookingId = bookingId; }

    public LocalDateTime getActualStart() { return actualStart; }
    public void setActualStart(LocalDateTime actualStart) { this.actualStart = actualStart; }

    public LocalDateTime getActualEnd() { return actualEnd; }
    public void setActualEnd(LocalDateTime actualEnd) { this.actualEnd = actualEnd; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public BigDecimal getFinalCost() { return finalCost; }
    public void setFinalCost(BigDecimal finalCost) { this.finalCost = finalCost; }

    public String getComputerName() { return computerName; }
    public void setComputerName(String computerName) { this.computerName = computerName; }
}