package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="ratings")
public class Rating {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ratingId;
    private Integer score;

    @ManyToOne
    @JsonIgnore
    private User ratedBy;

    @ManyToOne
    @JsonIgnore
    private Drink rated;

    public Integer getRatingId() {
        return ratingId;
    }

    public void setRatingId(Integer ratingId) {
        this.ratingId = ratingId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Rating(Integer score) {
        this.score = score;
    }

    public Rating() {}
}
