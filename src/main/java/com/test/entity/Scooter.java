package com.test.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "scooters")
public class Scooter {
    @Id
    @GeneratedValue
    private Long scooterID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Order order;

    public Scooter() {
    }

    public Scooter(Model model, Order order) {
        this.model = model;
        this.order = order;
    }

    public Long getScooterID() {
        return scooterID;
    }

    public void setScooterID(Long scooterID) {
        this.scooterID = scooterID;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Scooter scooter = (Scooter) o;
        return Objects.equals(scooterID, scooter.scooterID) && Objects.equals(model, scooter.model) && Objects.equals(order, scooter.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scooterID, model, order);
    }
}
