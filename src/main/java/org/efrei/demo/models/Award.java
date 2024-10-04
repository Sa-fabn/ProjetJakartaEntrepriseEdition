package org.efrei.demo.models;

import jakarta.persistence.*;

@Entity
public class Award {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;


    @Column(name = "movie_id", nullable = false)
    private String movieId;


    @Column(name = "award_name", nullable = false)
    private String awardName;


    // Constructeurs
    public Award(String movieId, String awardName) {
        this.movieId = movieId;
        this.awardName = awardName;
    }
    public Award() {}



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getAwardName() {
        return awardName;
    }

    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
}

