package com.athleticspot.neo4jplayground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

import javax.annotation.PostConstruct;

@SpringBootApplication
@EnableNeo4jRepositories
public class Neo4jPlaygroundApplication {


    @Autowired
    ActorRepository actorRepository;

    public static void main(String[] args) {
        SpringApplication.run(Neo4jPlaygroundApplication.class, args);
    }

    @PostConstruct
    public void init(){
        final Iterable<Actor> all = actorRepository.findAll();

        System.out.println("size: ");
    }
}
