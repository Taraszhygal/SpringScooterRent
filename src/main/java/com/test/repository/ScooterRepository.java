package com.test.repository;

import com.test.entity.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ScooterRepository extends JpaRepository<Scooter,Long> {

}
