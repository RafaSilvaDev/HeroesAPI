package com.project.heroesapi_j11.repository;

import com.project.heroesapi_j11.model.Power;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PowerRepo extends JpaRepository<Power, Long> {
}
