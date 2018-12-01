package com.athleticspot.neo4jplayground.application;

import com.athleticspot.neo4jplayground.domain.Athlete;
import com.athleticspot.neo4jplayground.domain.AthleteRepository;
import com.athleticspot.neo4jplayground.domain.SportActivity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Tomasz Kasprzycki
 */
@Component
@Transactional
public class AthleteApplicationService {

    private final AthleteRepository athleteRepository;

    public AthleteApplicationService(AthleteRepository athleteRepository) {
        this.athleteRepository = athleteRepository;
    }

    public void fallow(Long id, Long idToFallow) {
        final Athlete athleteToFallow = athleteRepository.findById(idToFallow)
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format("Athlete with give id: %s doesn't exists", idToFallow)));
        athleteRepository.findById(id).ifPresent(athlete ->
                {
                    athlete.fallow(athleteToFallow);
                    athleteRepository.save(athlete);
                }
        );

    }

    public void createAthlete(Athlete athlete) {
        athleteRepository.save(athlete);
    }

    public void perform(Long userId, Date date, String type) {
        athleteRepository.findById(userId).ifPresent(
                athlete -> {
                    athlete.perform(SportActivity.create(date, type));
                    athleteRepository.save(athlete);
                }
        );
    }
}
