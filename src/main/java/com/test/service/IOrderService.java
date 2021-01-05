package com.test.service;

import com.test.dto.OrderDTO;
import com.test.dto.ScooterDTO;

import java.util.List;

public interface IOrderService {
    OrderDTO getOrderById(Long id);

    List<OrderDTO> getOrdersByUserId(Long id);

    OrderDTO createOrder(OrderDTO orderDTO);

    List<OrderDTO> deleteOrder(Long id);

    List<ScooterDTO> addToOrder(Long orderId, ScooterDTO scooterDTO);

    List<OrderDTO> getAll();

    OrderDTO updateOrder(OrderDTO orderDTO, Long id);
}
