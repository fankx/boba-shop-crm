package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="drink_types")
public class DrinkType {
    @Id
    private String drinkType;

    @OneToOne(mappedBy = "drinkType")
    @JsonIgnore
    public Drink drink;

    public String getDrinkType() {
        return drinkType;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }


//    public List<Drink> getDrink() {
//        return drink;
//    }
//
//    public DrinkType(String drinkType, List<Drink> drink) {
//        this.drinkType = drinkType;
//        this.drink = drink;
//    }

    public DrinkType(){};
}
