package com.test.service.impl;

import com.test.dto.OrderDTO;
import com.test.entity.User;
import com.test.mapper.OrderMapper;
import com.test.repository.OrderRepository;
import com.test.repository.UserRepository;
import com.test.service.IOrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, UserRepository userRepository) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        return orderMapper.toDTO(orderRepository.findOrderById(id));
    }

    @Override
    public List<OrderDTO> getOrdersByUserId(Long id) {
        User user = userRepository.findUserById(id);
        return user.getOrderList().stream().map(orderMapper::toDTO).collect(Collectors.toList());
    }
}
