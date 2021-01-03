package com.test.mapper;

import com.test.dto.ScooterDTO;
import com.test.entity.Model;
import com.test.entity.Order;
import com.test.entity.Scooter;
import org.springframework.stereotype.Component;

@Component
public class ScooterMapper {
    public ScooterDTO toDTO(Scooter scooter){
        ScooterDTO scooterDTO = new ScooterDTO();
        scooterDTO.setScooterID(scooter.getId());
        scooterDTO.setModelName(scooter.getModel().getModelName());
        scooterDTO.setEnginePower(scooter.getModel().getEnginePower());
        scooterDTO.setPrice(scooter.getModel().getPrice());
        return scooterDTO;
    }

    public Scooter toEntity(ScooterDTO scooterDTO, final Model model, final Order order){
        Scooter scooter = new Scooter();
        scooter.setId(scooterDTO.getScooterID());
        scooter.setModel(model);
        scooter.setOrder(order);
        return scooter;
    }


}
