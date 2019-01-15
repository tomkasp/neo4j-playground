package com.athleticspot.neo4jplayground.application;

import com.athleticspot.neo4jplayground.domain.Athlete;
import com.athleticspot.neo4jplayground.domain.SportActivityReadRepository;
import com.athleticspot.neo4jplayground.domain.SportActivity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author Tomasz Kasprzycki
 */
@Component
@Transactional
public class AthleteApplicationService {

    private final SportActivityReadRepository sportActivityReadRepository;

    public AthleteApplicationService(SportActivityReadRepository sportActivityReadRepository) {
        this.sportActivityReadRepository = sportActivityReadRepository;
    }

    public void fallow(Long id, Long idToFallow) {
        final Athlete athleteToFallow = sportActivityReadRepository.findById(idToFallow)
                .orElseThrow(() ->
                        new IllegalArgumentException(String.format("Athlete with give id: %s doesn't exists", idToFallow)));
        sportActivityReadRepository.findById(id).ifPresent(athlete ->
                {
                    athlete.fallow(athleteToFallow);
                    sportActivityReadRepository.save(athlete);
                }
        );
    }

    public void createAthlete(Athlete athlete) {
        sportActivityReadRepository.save(athlete);
    }

    public void perform(Long userId, Date date, String type) {
        sportActivityReadRepository.findById(userId).ifPresent(
                athlete -> {
                    athlete.perform(SportActivity.create(date, type));
                    sportActivityReadRepository.save(athlete);
                }
        );
    }

    public void getPagedActivities(Long userId) {
        final Iterable<SportActivity> activitiesByUserId = sportActivityReadRepository.findActivitiesByUserId(userId);
        final Page<SportActivity> activitiesByUserId1 = sportActivityReadRepository.findActivitiesByUserId(PageRequest.of(0, 2));
        System.out.println(activitiesByUserId);
    }
}
