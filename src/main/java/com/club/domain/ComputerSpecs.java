package com.club.domain;

public class ComputerSpecs {
    private Long id;
    private String cpu;
    private String gpu;
    private Integer ram;
    private String storage;
    private String motherboard;
    private String powerSupply;
    private Long tariffId;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCpu() { return cpu; }
    public void setCpu(String cpu) { this.cpu = cpu; }

    public String getGpu() { return gpu; }
    public void setGpu(String gpu) { this.gpu = gpu; }

    public Integer getRam() { return ram; }
    public void setRam(Integer ram) { this.ram = ram; }

    public String getStorage() { return storage; }
    public void setStorage(String storage) { this.storage = storage; }

    public String getMotherboard() { return motherboard; }
    public void setMotherboard(String motherboard) { this.motherboard = motherboard; }

    public String getPowerSupply() { return powerSupply; }
    public void setPowerSupply(String powerSupply) { this.powerSupply = powerSupply; }

    public Long getTariffId() { return tariffId; }
    public void setTariffId(Long tariffId) { this.tariffId = tariffId; }
}