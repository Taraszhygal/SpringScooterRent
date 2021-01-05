package com.test.service;

import com.test.dto.ScooterDTO;

import java.util.List;

public interface IScooterService {
    ScooterDTO getScooterById(Long id);

    List<ScooterDTO> getAllByOrderId(Long id);

    List<ScooterDTO> saveScooter(ScooterDTO scooterDTO);

    List<ScooterDTO> deleteScooter(Long id);

    ScooterDTO updateScooter(ScooterDTO scooterDTO, Long id);

    List<ScooterDTO> getAll();
}
