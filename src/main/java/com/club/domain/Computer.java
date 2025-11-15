package com.club.domain;

public class Computer {
    private Long id;
    private String name;
    private Long specId;
    private String status; // свободен, занят, неисправен

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Long getSpecId() { return specId; }
    public void setSpecId(Long specId) { this.specId = specId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}