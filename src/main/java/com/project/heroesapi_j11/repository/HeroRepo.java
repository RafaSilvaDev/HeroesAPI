package com.project.heroesapi_j11.repository;

import com.project.heroesapi_j11.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepo extends JpaRepository<Hero, Long> {
}
