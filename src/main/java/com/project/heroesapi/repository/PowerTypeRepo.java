package com.project.heroesapi.repository;

import com.project.heroesapi.model.PowerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerTypeRepo extends JpaRepository<PowerType, Long> {
}
