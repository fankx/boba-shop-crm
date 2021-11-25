package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="rates")
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer score;
//    private Integer userId;
//    private Integer drinkId;

    @ManyToOne
    @JsonIgnore
    private Drink drink;

    @ManyToOne
    @JsonIgnore
    private User user;





    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public Rate( Integer score) {
        this.score = score;
    }

    public Rate() {}
}
