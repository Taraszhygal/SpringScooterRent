package com.test.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "models")
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String modelName;
    private int count;
    private int price;
    private int enginePower;
    private int maxWeight;

    @OneToMany(mappedBy = "model", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JoinColumn(name = "model_id", nullable = false)
    private List<Scooter> scooters;

    public Model(String modelName, int count, int price, int enginePower, int maxWeight, List<Scooter> scooters) {
        this.modelName = modelName;
        this.count = count;
        this.price = price;
        this.enginePower = enginePower;
        this.maxWeight = maxWeight;
        this.scooters = scooters;
    }

    public Model() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long modelID) {
        this.id = modelID;
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

    public List<Scooter> getScooters() {
        return scooters;
    }

    public void setScooters(List<Scooter> scooters) {
        this.scooters = scooters;
    }

    @Override
    public boolean equals(Object o) {
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return count == model.count && price == model.price && enginePower == model.enginePower && maxWeight == model.maxWeight && Objects.equals(id, model.id) && Objects.equals(modelName, model.modelName) && Objects.equals(scooters, model.scooters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, modelName, count, price, enginePower, maxWeight, scooters);
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelID=" + id +
                ", modelName='" + modelName + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", enginePower=" + enginePower +
                ", maxWeight=" + maxWeight +
                ", scooters=" + scooters +
                '}';
    }
}