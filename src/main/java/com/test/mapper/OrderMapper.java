package com.test.mapper;

import com.test.dto.OrderDTO;
import com.test.entity.Order;
import com.test.entity.User;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDTO toDTO(Order order){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderID(order.getId());
        orderDTO.setFirstName(order.getUser().getFirstName());
        orderDTO.setLastName(order.getUser().getLastName());
        orderDTO.setUserMail(order.getUser().getMail());
        orderDTO.setUserPhoneNumber(order.getUser().getPhoneNumber());
        orderDTO.setStartLocalDateTime(order.getStartLocalDateTime());
        return orderDTO;
    }

    public Order toEntity(OrderDTO orderDTO, final User user){
        Order order =new Order();
        order.setId(orderDTO.getOrderID());
        order.setStartLocalDateTime(order.getStartLocalDateTime());
        order.setUser(user);
        return order;
    }

}
