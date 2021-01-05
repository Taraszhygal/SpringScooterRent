package com.test.entity;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "scooters")
public class Scooter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.REFRESH)
    private Model model;

    public Scooter() {
    }

    public Scooter(Model model, Order order) {
        this.model = model;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return Objects.equals(id, scooter.id) && Objects.equals(model, scooter.model) && Objects.equals(order, scooter.order);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, order);
    }

    @Override
    public String toString() {
        return "Scooter{" +
                "id=" + id +
                '}';
    }
}
