package com.athleticspot.neo4jplayground.domain;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Tomasz Kasprzycki
 */
@NodeEntity
public class Athlete {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Athlete() {
        // Empty constructor required as of Neo4j API 2.0.5
    }

    ;

    public Athlete(String name) {
        this.name = name;
    }

    /**
     * Neo4j doesn't REALLY have bi-directional relationships. It just means when querying
     * to ignore the direction of the relationship.
     * https://dzone.com/articles/modelling-data-neo4j
     */
    @Relationship(type = "FALLOW", direction = Relationship.UNDIRECTED)
    public Set<Athlete> friends;

    public void fallow(Athlete person) {
        if (friends == null) {
            friends = new HashSet<>();
        }
        friends.add(person);
    }

    public void unfallow(Athlete unfallowAthlete) {
        this.friends.removeIf(athlete ->
                athlete.id.equals(unfallowAthlete.id)
        );
    }

    public void fetchAllFriends() {

    }

    public void fetchAllFriendsPaged() {

    }

    public void fetchMyActivities() {

    }

    public void fetchAllActivities() {

    }

    public void fetchAllActivitiesPaged() {

    }

    public String toString() {
        return this.name + "'s friends => "
                + Optional.ofNullable(this.friends).orElse(
                Collections.emptySet()).stream()
                .map(Athlete::getName)
                .collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
