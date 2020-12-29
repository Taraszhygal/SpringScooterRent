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
    @GeneratedValue
    private Long orderID;
    @DateTimeFormat(pattern = "YYYY-MM-DD hh:mm:ss")
    private LocalDateTime startLocalDateTime;
    private String userMail;
    private String userPhoneNumber;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    @OneToMany(targetEntity = Scooter.class, mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private List<Scooter> scooterList;

    public Order() {
    }

    public Order(LocalDateTime startLocalDateTime, String userMail, String userPhoneNumber, User user, List<Scooter> scooterList) {
        this.startLocalDateTime = startLocalDateTime;
        this.userMail = userMail;
        this.userPhoneNumber = userPhoneNumber;
        this.user = user;
        this.scooterList = scooterList;
    }

    public Order(LocalDateTime startLocalDateTime, String userMail, String userPhoneNumber, User user) {
        this.startLocalDateTime = startLocalDateTime;
        this.userMail = userMail;
        this.userPhoneNumber = userPhoneNumber;
        this.user = user;
    }

    public LocalDateTime getStartLocalDateTime() {
        return startLocalDateTime;
    }

    public void setStartLocalDateTime(LocalDateTime startLocalDateTime) {
        this.startLocalDateTime = startLocalDateTime;
    }

    public String getUserMail() {
        return userMail;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this.hashCode() != o.hashCode()) return false;
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderID, order.orderID) && Objects.equals(startLocalDateTime, order.startLocalDateTime) && Objects.equals(userMail, order.userMail) && Objects.equals(userPhoneNumber, order.userPhoneNumber) && Objects.equals(user, order.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderID, startLocalDateTime, userMail, userPhoneNumber, user);
    }
}
