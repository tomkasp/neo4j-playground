package com.athleticspot.neo4jplayground.domain;

import com.athleticspot.neo4jplayground.domain.Athlete;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Tomasz Kasprzycki
 */
public interface AthleteRepository  extends CrudRepository<Athlete, Long> {

}
