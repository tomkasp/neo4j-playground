package com.athleticspot.neo4jplayground;

import org.springframework.data.repository.CrudRepository;

/**
 * @author Tomasz Kasprzycki
 */
public interface AthleteRepository  extends CrudRepository<Athlete, Long> {

}
