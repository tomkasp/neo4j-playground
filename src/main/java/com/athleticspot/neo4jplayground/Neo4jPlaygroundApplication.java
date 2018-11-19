package com.athleticspot.neo4jplayground;

import com.athleticspot.neo4jplayground.domain.ActorRepository;
import com.athleticspot.neo4jplayground.domain.Athlete;
import com.athleticspot.neo4jplayground.domain.AthleteRepository;
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

    @Autowired
    AthleteRepository athleteRepository;

    public static void main(String[] args) {
        SpringApplication.run(Neo4jPlaygroundApplication.class, args);
    }

    @PostConstruct
    public void init() {

        Athlete athlete = new Athlete("Kasprzycki");
        Athlete dybala = new Athlete("Dybala");

        athleteRepository.save(dybala);
        athleteRepository.save(athlete);

        dybala.fallow(athlete);

        athleteRepository.save(dybala);
    }
}
