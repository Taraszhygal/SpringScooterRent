package com.test.service.impl;

import com.test.dto.ScooterDTO;
import com.test.entity.Model;
import com.test.entity.Order;
import com.test.entity.Scooter;
import com.test.exeption.ServiceException;
import com.test.mapper.ScooterMapper;
import com.test.repository.ModelRepository;
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
    private final ModelRepository modelRepository;
    private final ModelService modelService;


    public ScooterService(ScooterRepository scooterRepository, ScooterMapper scooterMapper, OrderRepository orderRepository, ModelRepository modelRepository, ModelService modelService) {
        this.scooterRepository = scooterRepository;
        this.scooterMapper = scooterMapper;
        this.orderRepository = orderRepository;
        this.modelRepository = modelRepository;
        this.modelService = modelService;
    }

    @Override
    public ScooterDTO getScooterById(Long id) {
        Scooter scooter = scooterRepository.findScooterById(id);
        return scooterMapper.toDTO(scooter);
    }

    @Override
    public List<ScooterDTO> getAllByOrderId(Long id) {
        Order order = orderRepository.findOrderById(id);
        return order.getScooterList().stream()
                .map(scooterMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScooterDTO> getScootersByModel(String modelName) {
        List<Scooter> byModel = scooterRepository.findAll();
        return byModel.stream()
                .filter(scooter -> scooter.getModel().getModelName().equals(modelName))
                .map(scooterMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ScooterDTO> saveScooter(ScooterDTO scooterDTO) {
        Model model = modelRepository.findModelByModelName(scooterDTO.getModelName());
        Scooter scooter = scooterMapper.toEntity(scooterDTO, model, null);
        scooterRepository.save(scooter);
        modelService.incrementModelCount(model.getModelName());
        return getAll();
    }

    @Override
    public List<ScooterDTO> deleteScooter(Long id) {
        try {
            Scooter scooter = scooterRepository.findScooterById(id);
            scooterRepository.deleteById(id);
            modelService.decrementModelCount(scooter.getModel().getModelName());
        } catch (Exception e) {
            throw new ServiceException(400, "Incorrect scooter id", null);
        }
        return getAll();
    }

    @Override
    public ScooterDTO updateScooter(ScooterDTO scooterDTO, Long id) {
        Model model = modelRepository.findModelByModelName(scooterDTO.getModelName());
        Order order = orderRepository.findOrderById(scooterDTO.getOrderID());
        Scooter scooter = scooterMapper.toEntity(scooterDTO, model, order);
        Scooter updatedScooter = scooterRepository.findScooterById(id);
        if (updatedScooter != null && id != 0) {
            updatedScooter.setModel(scooter.getModel());
            updatedScooter.setOrder(scooter.getOrder());
            scooterRepository.save(updatedScooter);
            return scooterMapper.toDTO(updatedScooter);
        } else {
            throw new ServiceException(400, "Scooter should have an id", null);
        }
    }

    @Override
    public List<ScooterDTO> getAll() {
        List<Scooter> all = scooterRepository.findAll();
        return all.stream().map(scooterMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ScooterDTO> addToOrder(Long orderId, String modelName) {
        List<ScooterDTO> all = this.getScootersByModel(modelName);
        ScooterDTO scooterDTO = all.stream()
                .filter(e -> e.getOrderID() == null)
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "We don`t have free scooters", null));
        scooterDTO.setOrderID(orderId);
        this.updateScooter(scooterDTO,scooterDTO.getScooterID());
        return this.getAllByOrderId(orderId);
    }
}
