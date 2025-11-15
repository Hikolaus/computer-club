package com.club.dto;

import java.math.BigDecimal;

public class ComputerDto {
    private Long id;
    private String name;
    private String cpu;
    private String gpu;
    private Integer ram;
    private String status;
    private BigDecimal pricePerHour;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }

    public String getGpu() { return gpu; }
    public void setGpu(String gpu) { this.gpu = gpu; }

    public Integer getRam() { return ram; }
    public void setRam(Integer ram) { this.ram = ram; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public BigDecimal getPricePerHour() { return pricePerHour; }
    public void setPricePerHour(BigDecimal pricePerHour) { this.pricePerHour = pricePerHour; }
}