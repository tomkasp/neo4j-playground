package com.athleticspot.neo4jplayground.infrastracture.web.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.util.Date;

/**
 * @author Tomasz Kasprzycki
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SportActivityDto {

    private Long userId;

    private Date date;

    private String type;

    public Long getUserId() {
        return userId;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }
}
