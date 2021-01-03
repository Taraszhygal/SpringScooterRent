package com.test.controller;

import com.test.dto.ModelDTO;
import com.test.dto.UserDTO;
import com.test.service.impl.ModelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("model")
public class ModelController {
    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }
    @PostMapping("/")
    public List<ModelDTO> saveModel(@RequestBody ModelDTO modelDTO) {
        return modelService.saveModel(modelDTO);
    }

    @GetMapping("/{id}")
    public ModelDTO getModelById(@PathVariable Long id) {
        return modelService.getModelById(id);
    }

    @GetMapping("/name/{name}")
    public ModelDTO getModelByName(@PathVariable String name) {
        return modelService.getModelByName(name);
    }

    @GetMapping("/")
    public List<ModelDTO> getAll() {
        return modelService.getAll();
    }

    @DeleteMapping("/{id}")
    public List<ModelDTO> deleteModel(@PathVariable Long id){
        return modelService.deleteModelById(id);
    }

    @PutMapping("/{name}")
    public ModelDTO updateModel(@RequestBody ModelDTO modelDTO,@PathVariable String name){
        return modelService.updateModel(modelDTO,name);
    }
}
