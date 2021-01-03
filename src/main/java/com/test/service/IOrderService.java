package com.test.service;

import com.test.dto.OrderDTO;

import java.util.List;

public interface IOrderService {
    OrderDTO getOrderById(Long id);
    List<OrderDTO> getOrdersByUserId(Long id);
}
