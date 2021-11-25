package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="drinks")
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JsonIgnore
    private DrinkType drinkType;

    @OneToMany(mappedBy = "drink")
    @JsonIgnore
    private List<OrderAssign2Drink> orderAssign2Drink;

    @OneToMany(mappedBy = "drink")
    @JsonIgnore
    private List<DrinkAssign2Cook> drinkAssign2Cooks;

    @OneToMany(mappedBy = "drink")
    @JsonIgnore
    private List<Rate> rates;

    // change something
    public Drink() {}
}
