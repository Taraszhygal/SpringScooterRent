package com.test.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public class OrderDTO {
    private Long orderID;
    private LocalDateTime startLocalDateTime;
    private String firstName;
    private String lastName;
    private String userMail;
    private String userPhoneNumber;

    public OrderDTO() {
    }

    public OrderDTO(Long orderID, LocalDateTime startLocalDateTime, String firstName, String lastName, String userMail, String userPhoneNumber) {
        this.orderID = orderID;
        this.startLocalDateTime = startLocalDateTime;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userMail = userMail;
        this.userPhoneNumber = userPhoneNumber;
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public LocalDateTime getStartLocalDateTime() {
        return startLocalDateTime;
    }

    public void setStartLocalDateTime(LocalDateTime startLocalDateTime) {
        this.startLocalDateTime = startLocalDateTime;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserMail() {
        return userMail;
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
}
