package com.athleticspot.neo4jplayground.infrastracture.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * @author Tomasz Kasprzycki
 */
@JsonDeserialize
@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE)
public class FallowDto {

    private String athleteId;
    private String athleteIdToFallow;

    public String getAthleteId() {
        return athleteId;
    }

    public String getAthleteIdToFallow() {
        return athleteIdToFallow;
    }
}
