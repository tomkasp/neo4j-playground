package com.athleticspot.neo4jplayground.infrastracture.web;

import com.athleticspot.neo4jplayground.application.AthleteApplicationService;
import com.athleticspot.neo4jplayground.domain.Athlete;
import com.athleticspot.neo4jplayground.domain.AthleteRepository;
import com.athleticspot.neo4jplayground.infrastracture.web.dto.AthleteInDto;
import com.athleticspot.neo4jplayground.infrastracture.web.dto.FallowDto;
import com.athleticspot.neo4jplayground.infrastracture.web.dto.SportActivityDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Tomasz Kasprzycki
 */
@RestController
@RequestMapping(value = "/athlete")
public class AthleteController {

    private final AthleteApplicationService athleteApplicationService;

    private final AthleteRepository athleteRepository;

    public AthleteController(AthleteApplicationService athleteApplicationService,
                             AthleteRepository athleteRepository) {
        this.athleteApplicationService = athleteApplicationService;
        this.athleteRepository = athleteRepository;
    }

    @GetMapping
    public List<Athlete> getAthlete(@RequestParam String name) {
        final List<Athlete> byNameIgnoreCase = athleteRepository.findByNameContainingIgnoreCase(name);
        return byNameIgnoreCase;
    }

    @PutMapping(value = "/fallow")
    public void fallow(@RequestBody FallowDto fallowDto) {
        athleteApplicationService.fallow(
                Long.parseLong(fallowDto.getAthleteId()),
                Long.parseLong(fallowDto.getAthleteIdToFallow())
        );
    }

    @PutMapping(value = "/perform")
    public void fallow(@RequestBody SportActivityDto sportActivityDto) {
        athleteApplicationService.perform(
                sportActivityDto.getUserId(),
                sportActivityDto.getDate(),
                sportActivityDto.getType()
        );
    }

    /**
     * Gets paged activities of user and all people which certain user fallows.
     */
    @GetMapping(value = "/activities")
    public void getSportActivitiesPaged(@RequestParam Long userId) {
        athleteApplicationService.getPagedActivities(userId);
    }

    @DeleteMapping(value = "/fallow")
    public void unfallow() {

    }

    @PostMapping
    public void createAthlete(@RequestBody AthleteInDto athleteInDto) {
        Athlete athlete = new Athlete(athleteInDto.getName());
        this.athleteApplicationService.createAthlete(athlete);
    }

}

