package com.example.springtemplate.models;//package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="drink_assign_2_cook")
public class DrinkAssign2Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JsonIgnore
    private CookEmployee cookEmployee;

    @ManyToOne
    @JsonIgnore
    private Drink drink;



}
