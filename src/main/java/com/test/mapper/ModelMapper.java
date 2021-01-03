package com.test.mapper;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.test.dto.ModelDTO;
import com.test.entity.Model;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {
   public ModelDTO toDTO(Model model){
        ModelDTO modelDTO = new ModelDTO();
        modelDTO.setModelID(model.getId());
        modelDTO.setModelName(model.getModelName());
        modelDTO.setEnginePower(model.getEnginePower());
        modelDTO.setMaxWeight(model.getMaxWeight());
        modelDTO.setCount(model.getCount());
        modelDTO.setPrice(model.getPrice());
        return modelDTO;
    }

   public Model toEntity(ModelDTO modelDTO){
        Model model = new Model();
        model.setId(modelDTO.getModelID());
        model.setModelName(modelDTO.getModelName());
        model.setEnginePower(modelDTO.getEnginePower());
        model.setMaxWeight(modelDTO.getMaxWeight());
        model.setCount(modelDTO.getCount());
        model.setPrice(modelDTO.getPrice());
        return model;
    }

}
