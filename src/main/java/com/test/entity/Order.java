package com.test.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private LocalDateTime startLocalDateTime;

    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@JoinColumn(name = "order_id", nullable = false)
    private List<Scooter> scooterList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User user;

    public Order() {
    }

    public Order(Long orderID, LocalDateTime startLocalDateTime, User user, List<Scooter> scooterList) {
        this.id = orderID;
        this.startLocalDateTime = startLocalDateTime;
        this.user = user;
        this.scooterList = scooterList;
    }

    public LocalDateTime getStartLocalDateTime() {
        return startLocalDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long orderID) {
        this.id = orderID;
    }

    public void setStartLocalDateTime(LocalDateTime startLocalDateTime) {
        this.startLocalDateTime = startLocalDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Scooter> getScooterList() {
        return scooterList;
    }

    public void setScooterList(List<Scooter> scooterList) {
        this.scooterList = scooterList;
    }

    @Override
    public boolean equals(Object o) {
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(startLocalDateTime, order.startLocalDateTime)  && Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startLocalDateTime, user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + id +
                ", startLocalDateTime=" + startLocalDateTime +
                ", user=" + user +
                ", scooterList=" + scooterList +
                '}';
    }
}
