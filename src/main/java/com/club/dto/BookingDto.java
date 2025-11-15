package com.club.dto;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class BookingDto {
    private Long id;
    private Long userId;
    private Long computerId;
    private String computerName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
    private BigDecimal totalCost;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getComputerId() { return computerId; }
    public void setComputerId(Long computerId) { this.computerId = computerId; }

    public String getComputerName() { return computerName; }
    public void setComputerName(String computerName) { this.computerName = computerName; }

    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }

    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getTotalCost() { return totalCost; }
    public void setTotalCost(BigDecimal totalCost) { this.totalCost = totalCost; }
}