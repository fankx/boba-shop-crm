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

    @OneToOne
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DrinkType getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(DrinkType drinkType) {
        this.drinkType = drinkType;
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

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public Drink() {}

    public Drink (Integer id, String name, Integer price, List<OrderAssign2Drink> orderAssign2Drink, List<DrinkAssign2Cook> drinkAssign2Cooks, List<Rate> rates) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orderAssign2Drink = orderAssign2Drink;
        this.drinkAssign2Cooks = drinkAssign2Cooks;
        this.rates = rates;
    }
}
