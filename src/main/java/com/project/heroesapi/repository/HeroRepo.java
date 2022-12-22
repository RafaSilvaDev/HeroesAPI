package com.project.heroesapi.repository;

import com.project.heroesapi.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepo extends JpaRepository<Hero, Long> {
}
