package com.athleticspot.neo4jplayground.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Tomasz Kasprzycki
 */
@Repository
public interface AthleteRepository extends CrudRepository<Athlete, Long> {

    List<Athlete> findByNameContainingIgnoreCase(String name);

}
