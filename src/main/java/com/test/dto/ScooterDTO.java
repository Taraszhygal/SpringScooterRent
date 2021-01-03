package com.test.dto;

public class ScooterDTO {
    private Long scooterID;
    private String modelName;
    private int enginePower;
    private int price;

    public ScooterDTO() {
    }

    public ScooterDTO(Long scooterID, String modelName, int enginePower, int price) {
        this.scooterID = scooterID;
        this.modelName = modelName;
        this.enginePower = enginePower;
        this.price = price;
    }

    public Long getScooterID() {
        return scooterID;
    }

    public void setScooterID(Long scooterID) {
        this.scooterID = scooterID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
