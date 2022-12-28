package com.project.heroesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EntityScan(basePackages = "com.project.heroesapi.model")
@EnableSwagger2

/*
mostra pro Ricardo:
https://stackoverflow.com/questions/71549614/springfox-type-javax-servlet-http-httpservletrequest-not-present
 */
public class HeroesApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HeroesApiApplication.class, args);
    }

}
