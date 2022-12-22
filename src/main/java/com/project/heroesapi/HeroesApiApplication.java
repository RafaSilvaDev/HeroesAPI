package com.project.heroesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.project.heroesapi")
@EntityScan(basePackages = "com.project.heroesapi.model")
public class HeroesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroesApiApplication.class, args);
    }

}
