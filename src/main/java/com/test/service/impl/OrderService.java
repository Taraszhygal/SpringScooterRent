package com.test.service.impl;

import com.test.dto.OrderDTO;
import com.test.dto.ScooterDTO;
import com.test.entity.Order;
import com.test.entity.Scooter;
import com.test.entity.User;
import com.test.exeption.ServiceException;
import com.test.mapper.OrderMapper;
import com.test.mapper.ScooterMapper;
import com.test.repository.OrderRepository;
import com.test.repository.UserRepository;
import com.test.service.IOrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService {
    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ScooterService scooterService;
    private final ScooterMapper scooterMapper;


    public OrderService(OrderMapper orderMapper, OrderRepository orderRepository, UserRepository userRepository, ScooterService scooterService, ScooterMapper scooterMapper) {
        this.orderMapper = orderMapper;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.scooterService = scooterService;
        this.scooterMapper = scooterMapper;
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

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        User user = userRepository.findUserByMail(orderDTO.getUserMail());
        Order order = orderMapper.toEntity(orderDTO, user);
        String currentDateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        order.setStartLocalDateTime(currentDateTime);
        orderRepository.save(order);
        return orderMapper.toDTO(order);
    }

    @Override
    public List<OrderDTO> deleteOrder(Long id) {
        Order order = orderRepository.findOrderById(id);
        User user = order.getUser();
        //delete scooters from order
        order.getScooterList().stream()
                .map(scooterMapper::toDTO)
                .peek(scooterDTO -> scooterDTO.setOrderID(null))
                .peek(scooterDTO -> scooterService.updateScooter(scooterDTO, scooterDTO.getScooterID()))
                .collect(Collectors.toList());
        orderRepository.delete(orderRepository.findOrderById(id));
        return getOrdersByUserId(user.getId());
    }

    @Override
    public List<ScooterDTO> addToOrder(Long orderId, ScooterDTO scooterDTO) {
        return scooterService.addToOrder(orderId, scooterDTO.getModelName());
    }

    @Override
    public List<OrderDTO> getAll() {
        List<Order> all = orderRepository.findAll();
        return all.stream().map(orderMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO, Long id) {
        User user = userRepository.findUserByMail(orderDTO.getUserMail());
        Order order = orderMapper.toEntity(orderDTO, user);
        Order updatedOrder = orderRepository.findOrderById(id);
        if (updatedOrder != null && id != 0) {
            updatedOrder.setUser(order.getUser());
            updatedOrder.setStartLocalDateTime(order.getStartLocalDateTime());
            orderRepository.save(updatedOrder);
            return orderMapper.toDTO(updatedOrder);
        } else {
            throw new ServiceException(400, "Order should have an id and exist", null);
        }
    }
}
