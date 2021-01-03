package com.test.repository;

import com.test.entity.Scooter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScooterRepository extends JpaRepository<Scooter,Long> {

}
