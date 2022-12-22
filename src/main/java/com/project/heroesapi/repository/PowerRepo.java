package com.project.heroesapi.repository;

import com.project.heroesapi.model.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerRepo extends JpaRepository<Power, Long> {
}
