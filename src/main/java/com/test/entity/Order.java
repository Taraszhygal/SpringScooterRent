package com.test.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String startLocalDateTime;
    private int totalPrice;
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    //@JoinColumn(name = "order_id", nullable = false)
    private List<Scooter> scooterList;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    private User user;

    public Order() {
    }

    public Order(Long id, String startLocalDateTime, int totalPrice, List<Scooter> scooterList, User user) {
        this.id = id;
        this.startLocalDateTime = startLocalDateTime;
        this.totalPrice = totalPrice;
        this.scooterList = scooterList;
        this.user = user;
    }

    public String getStartLocalDateTime() {
        return startLocalDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long orderID) {
        this.id = orderID;
    }

    public void setStartLocalDateTime(String startLocalDateTime) {
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

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(startLocalDateTime, order.startLocalDateTime) && Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startLocalDateTime, totalPrice, user);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", startLocalDateTime='" + startLocalDateTime + '\'' +
                ", totalPrice=" + totalPrice +
                ", scooterList=" + scooterList +
                ", user=" + user +
                '}';
    }
}
