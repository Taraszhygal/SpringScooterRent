package com.test.repository;

import com.test.entity.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Long> {
    Model findModelById(Long id);
    Model findModelByModelName(String modelName);
}
