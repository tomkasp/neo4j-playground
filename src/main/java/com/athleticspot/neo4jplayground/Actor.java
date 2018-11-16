package com.athleticspot.neo4jplayground;

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
public class Actor {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Actor() {
        // Empty constructor required as of Neo4j API 2.0.5
    };

    public Actor(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
