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
    private String name;
    private Integer price;
//    @ManyToOne
//    @JsonIgnore
//    private DrinkType drinkType;

    @OneToMany(mappedBy = "drink")
    @JsonIgnore
    private List<OrderAssign2Drink> orderAssign2Drink;

    @OneToMany(mappedBy = "drink")
    @JsonIgnore
    private List<DrinkAssign2Cook> drinkAssign2Cooks;

    @OneToMany(mappedBy = "rated")
    @JsonIgnore
    private List<Rating> ratings;

    @Transient
    public Integer getAvgRating() {
        int sum = 0;
        for (int i = 0; i < ratings.size(); i++) {
            sum += ratings.get(i).getScore();
        }
        return sum / ratings.size();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public DrinkType getDrinkType() {
//        return drinkType;
//    }
//
//    public void setDrinkType(DrinkType drinkType) {
//        this.drinkType = drinkType;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public List<OrderAssign2Drink> getOrderAssign2Drink() {
        return orderAssign2Drink;
    }

    public void setOrderAssign2Drink(List<OrderAssign2Drink> orderAssign2Drink) {
        this.orderAssign2Drink = orderAssign2Drink;
    }

    public List<DrinkAssign2Cook> getDrinkAssign2Cooks() {
        return drinkAssign2Cooks;
    }

    public void setDrinkAssign2Cooks(List<DrinkAssign2Cook> drinkAssign2Cooks) {
        this.drinkAssign2Cooks = drinkAssign2Cooks;
    }

    public List<Rating> getRates() {
        return ratings;
    }

    public void setRates(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public Drink() {}

    public Drink (Integer id, String name, Integer price, List<OrderAssign2Drink> orderAssign2Drink, List<DrinkAssign2Cook> drinkAssign2Cooks, List<Rating> ratings) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orderAssign2Drink = orderAssign2Drink;
        this.drinkAssign2Cooks = drinkAssign2Cooks;
        this.ratings = ratings;
    }
}
