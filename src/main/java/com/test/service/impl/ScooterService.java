package com.test.service.impl;

import com.test.dto.ScooterDTO;
import com.test.entity.Order;
import com.test.entity.Scooter;
import com.test.mapper.ScooterMapper;
import com.test.repository.OrderRepository;
import com.test.repository.ScooterRepository;
import com.test.service.IScooterService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScooterService implements IScooterService {
private final ScooterRepository scooterRepository;
private final ScooterMapper scooterMapper;
private final OrderRepository orderRepository;


    public ScooterService(ScooterRepository scooterRepository, ScooterMapper scooterMapper, OrderRepository orderRepository) {
        this.scooterRepository = scooterRepository;
        this.scooterMapper = scooterMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public ScooterDTO getScooterById(Long id) {
        Scooter scooter = scooterRepository.findScooterById(id);
        return scooterMapper.toDTO(scooter);
    }

    public List<ScooterDTO> getAllByOrderId(Long id){
       Order order = orderRepository.findOrderById(id);
        return order.getScooterList().stream()
                .map(scooterMapper::toDTO)
                .collect(Collectors.toList());
     }
}
