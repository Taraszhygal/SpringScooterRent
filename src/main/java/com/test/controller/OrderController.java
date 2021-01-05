package com.test.controller;

import com.test.dto.OrderDTO;
import com.test.dto.ScooterDTO;
import com.test.service.impl.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/")
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @GetMapping("/")
    public List<OrderDTO> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/user_{id}")
    public List<OrderDTO> getOrdersByUserId(@PathVariable Long id) {
        return orderService.getOrdersByUserId(id);
    }

    @PutMapping("/add_to_{orderId}/")
    public List<ScooterDTO> addScooterToOrder(@PathVariable Long orderId,@RequestBody ScooterDTO scooterDTO) {
        return orderService.addToOrder(orderId,scooterDTO);
    }

    @DeleteMapping("/{id}")
    public List<OrderDTO> deleteOrder(@PathVariable Long id){
        return orderService.deleteOrder(id);
    }

    @PutMapping("/{id}")
    public OrderDTO updateOrder(@RequestBody OrderDTO orderDTO,@PathVariable Long id){
        return orderService.updateOrder(orderDTO,id);
    }
}
