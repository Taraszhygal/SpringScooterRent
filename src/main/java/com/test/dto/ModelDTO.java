package com.test.dto;

public class ModelDTO {
    private Long modelID;
    private String modelName;
    private int count;
    private int price;
    private int enginePower;
    private int maxWeight;

    public ModelDTO() {
    }

    public ModelDTO(Long modelID, String modelName, int count, int price, int enginePower, int maxWeight) {
        this.modelID = modelID;
        this.modelName = modelName;
        this.count = count;
        this.price = price;
        this.enginePower = enginePower;
        this.maxWeight = maxWeight;
    }

    public Long getModelID() {
        return modelID;
    }

    public void setModelID(Long modelID) {
        this.modelID = modelID;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
}
