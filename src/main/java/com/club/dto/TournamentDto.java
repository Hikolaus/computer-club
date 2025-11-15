package com.club.dto;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public class TournamentDto {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dateTime;
    private BigDecimal prizeFund;
    private String status;
    private Integer participantsCount;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public BigDecimal getPrizeFund() { return prizeFund; }
    public void setPrizeFund(BigDecimal prizeFund) { this.prizeFund = prizeFund; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Integer getParticipantsCount() { return participantsCount; }
    public void setParticipantsCount(Integer participantsCount) { this.participantsCount = participantsCount; }
}