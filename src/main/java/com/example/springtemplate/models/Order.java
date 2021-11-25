package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(name = "user_id",insertable = false, updatable = false)
//    private Integer userId;
    private Integer amount;
    private Float tip;
    private Float discount;


    @ManyToOne
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderAssign2Delivery> orderAssign2Deliveries;

    @OneToMany(mappedBy = "order")
    @JsonIgnore
    private List<OrderAssign2Drink> orderAssign2Drinks;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Float getTip() {
        return tip;
    }

    public void setTip(Float tip) {
        this.tip = tip;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderAssign2Delivery> getOrderAssign2Deliveries() {
        return orderAssign2Deliveries;
    }

    public void setOrderAssign2Deliveries(List<OrderAssign2Delivery> orderAssign2Deliveries) {
        this.orderAssign2Deliveries = orderAssign2Deliveries;
    }

    public List<OrderAssign2Drink> getDishAssignments() {
        return orderAssign2Drinks;
    }

    public void setDishAssignments(List<OrderAssign2Drink> dishAssignments) {
        this.orderAssign2Drinks = dishAssignments;
    }


    public Order(Integer amount, Float tip, Float discount, User user, List<OrderAssign2Delivery> orderAssign2Deliveries, List<OrderAssign2Drink> dishAssignments) {
        this.amount = amount;
        this.tip = tip;
        this.discount = discount;
        this.user = user;
        this.orderAssign2Deliveries = orderAssign2Deliveries;
        this.orderAssign2Drinks = dishAssignments;
    }

    public Order(){

    }
}

