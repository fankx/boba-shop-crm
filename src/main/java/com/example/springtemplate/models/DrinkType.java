package com.example.springtemplate.models;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="drink_types")
public class DrinkType {
    @Id
    private String drinkType;

//    @OneToMany(mappedBy = "drinkType")
//    public List<Drink> drink;

    public String getDrinkType() {
        return drinkType;
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
