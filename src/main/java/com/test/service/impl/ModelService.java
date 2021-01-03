package com.test.service.impl;

import com.test.dto.ModelDTO;
import com.test.dto.UserDTO;
import com.test.entity.Model;
import com.test.entity.User;
import com.test.exeption.ServiceException;
import com.test.mapper.ModelMapper;
import com.test.repository.ModelRepository;
import com.test.service.IModelService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ModelService implements IModelService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public ModelService(ModelRepository modelRepository, ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelDTO getModelById(Long id) {
        return modelMapper.toDTO(modelRepository.findModelById(id));
    }

    @Override
    public  ModelDTO getModelByName(String modelName){
        return modelMapper.toDTO(modelRepository.findModelByModelName(modelName));
    }

    @Override
    public List<ModelDTO> saveModel(ModelDTO modelDTO) {
        Model model = modelMapper.toEntity(modelDTO);
        modelRepository.save(model);
        return getAll();
    }

    @Override
    public List<ModelDTO> getAll() {
        List<Model> all = modelRepository.findAll();
        return all.stream().map(modelMapper::toDTO).collect(Collectors.toList());
    }
    @Override
    public List<ModelDTO> deleteModelById(Long id){
        modelRepository.deleteById(id);
        return getAll();
    }

    @Override
    public ModelDTO updateModel(ModelDTO modelDTO, String modelName) {
        Model model = modelMapper.toEntity(modelDTO);
        Model updatedModel = modelRepository.findModelByModelName(modelName);
        if (updatedModel != null && modelName.length() !=0 ) {
            updatedModel.setModelName(model.getModelName());
            updatedModel.setPrice(model.getPrice());
            updatedModel.setEnginePower(model.getEnginePower());
            updatedModel.setCount(model.getCount());
            updatedModel.setMaxWeight(model.getMaxWeight());
            modelRepository.save(updatedModel);
            return modelMapper.toDTO(updatedModel);
        } else {
            throw new ServiceException(400, "User should have an id", null);
        }
    }
}
