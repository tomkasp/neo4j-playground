package com.athleticspot.neo4jplayground.infrastracture.web;

import com.athleticspot.neo4jplayground.application.AthleteApplicationService;
import com.athleticspot.neo4jplayground.domain.Athlete;
import com.athleticspot.neo4jplayground.infrastracture.web.dto.AthleteInDto;
import com.athleticspot.neo4jplayground.infrastracture.web.dto.FallowDto;
import com.athleticspot.neo4jplayground.infrastracture.web.dto.SportActivityDto;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tomasz Kasprzycki
 */
@RestController
@RequestMapping(value = "/athlete")
public class AthleteController {

    private final AthleteApplicationService athleteApplicationService;

    public AthleteController(AthleteApplicationService athleteApplicationService) {
        this.athleteApplicationService = athleteApplicationService;
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
     *
     */
    @GetMapping(value = "/activities")
    public void getSportActivitiesPaged(@RequestParam Long userId){
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

