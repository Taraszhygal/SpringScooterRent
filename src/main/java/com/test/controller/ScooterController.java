package com.test.controller;

import com.test.dto.ScooterDTO;
import com.test.service.impl.ScooterService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("scooter")
public class ScooterController {
    private final ScooterService scooterService;

    public ScooterController(ScooterService scooterService) {
        this.scooterService = scooterService;
    }

    @PostMapping("/")
    public List<ScooterDTO> createScooter(@RequestBody ScooterDTO scooterDTO) {
        return scooterService.saveScooter(scooterDTO);
    }

    @GetMapping("/{id}")
    public ScooterDTO getScooterById(@PathVariable Long id) {
        return scooterService.getScooterById(id);
    }

    @GetMapping("/in_order/{id}")
    public List<ScooterDTO> getScootersByOderId(@PathVariable Long id) {
        return scooterService.getAllByOrderId(id);
    }

    @GetMapping("/")
    public List<ScooterDTO> getAll() {
        return scooterService.getAll();
    }

    @DeleteMapping("/{id}")
    public List<ScooterDTO> deleteScooter(@PathVariable Long id){
        return scooterService.deleteScooter(id);
    }

    @PutMapping("/{id}")
    public ScooterDTO updateScooter(@RequestBody ScooterDTO scooterDTO,@PathVariable Long id){
        return scooterService.updateScooter(scooterDTO,id);
    }
}
