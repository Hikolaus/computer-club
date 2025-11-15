package com.club.dto;

import java.time.LocalDateTime;

public class SupportTicketDto {
    private Long id;
    private Long userId;
    private Long computerId;
    private String computerName;
    private String categoryName;
    private String description;
    private String status;
    private LocalDateTime createdAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public Long getComputerId() { return computerId; }
    public void setComputerId(Long computerId) { this.computerId = computerId; }

    public String getComputerName() { return computerName; }
    public void setComputerName(String computerName) { this.computerName = computerName; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}