package com.athleticspot.neo4jplayground.domain;

import com.athleticspot.neo4jplayground.domain.Athlete;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Tomasz Kasprzycki
 */
public interface AthleteRepository  extends CrudRepository<Athlete, Long> {

    @Query("Match (a:Athlete{name:\"Tomasz Kasprzycki\"})-[r:FALLOW]->(n:Athlete)-[g:PERFORM]->(h:SportActivity)" +
            "return h as sa union match (t:Athlete{name:\"Tomasz Kasprzycki\"})-[:PERFORM]->(z:SportActivity) return z as sa")
    Iterable<SportActivity> findActivitiesByUserId();
}



