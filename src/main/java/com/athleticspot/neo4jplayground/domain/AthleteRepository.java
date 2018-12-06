package com.athleticspot.neo4jplayground.domain;

import com.athleticspot.neo4jplayground.domain.Athlete;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Tomasz Kasprzycki
 */
public interface AthleteRepository  extends CrudRepository<Athlete, Long> {

    @Query("Match (a:Athlete{name:\"Tomasz Kasprzycki\"})-[r:FALLOW]->(n:Athlete)-[g:PERFORM]->(h:SportActivity) with collect(h) as rows " +
            "match (t:Athlete{name:\"Tomasz Kasprzycki\"})-[:PERFORM]->(z:SportActivity) with rows + collect(z) as allRows " +
            "UNWIND allRows as row " +
            "return row")
    Iterable<SportActivity> findActivitiesByUserId(Long userId);


    @Query(value = "Match (a:Athlete{name:\"Tomasz Kasprzycki\"})-[r:FALLOW]->(n:Athlete)-[g:PERFORM]->(h:SportActivity) with collect(h) as rows " +
            "match (t:Athlete{name:\"Tomasz Kasprzycki\"})-[:PERFORM]->(z:SportActivity) with rows + collect(z) as allRows " +
            "UNWIND allRows as row " +
            "return row",
    countQuery = "Match (a:Athlete{name:\"Tomasz Kasprzycki\"})-[r:FALLOW]->(n:Athlete)-[g:PERFORM]->(h:SportActivity) with collect(h) as rows " +
            "match (t:Athlete{name:\"Tomasz Kasprzycki\"})-[:PERFORM]->(z:SportActivity) with rows + collect(z) as allRows " +
            "UNWIND allRows as row " +
            "return count(row)")
    Page<SportActivity> findActivitiesByUserId(PageRequest of);
}
