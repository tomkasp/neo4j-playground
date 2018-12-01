package com.athleticspot.neo4jplayground.infrastracture.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

/**
 * @author Tomasz Kasprzycki
 */
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FallowDto {

    private String athleteId;
    private String athleteIdToFallow;

    public String getAthleteId() {
        return athleteId;
    }

    public String getAthleteIdToFallow() {
        return athleteIdToFallow;
    }

    @Override
    public String toString() {
        return "FallowDto{" +
                "athleteId='" + athleteId + '\'' +
                ", athleteIdToFallow='" + athleteIdToFallow + '\'' +
                '}';
    }
}
