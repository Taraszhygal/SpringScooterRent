package com.test.service;

import com.test.dto.ModelDTO;

import java.util.List;

public interface IModelService{
    ModelDTO getModelById(Long id);
    ModelDTO getModelByName(String modelName);
    List<ModelDTO> saveModel(ModelDTO modelDTO);
    List<ModelDTO> getAll();
    List<ModelDTO> deleteModelById(Long id);
    ModelDTO updateModel(ModelDTO modelDTO, String modelName);

    void incrementModelCount(String modelName);
}
