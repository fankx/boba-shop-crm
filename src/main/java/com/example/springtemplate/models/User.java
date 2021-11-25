package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
//@Inheritance(strategy = InheritanceType.JOINED)
public class User extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerValue;

//    @OneToOne
//    @JsonIgnore
//    private Person person;

//    @OneToMany(mappedBy = "user")
//    @JsonIgnore
//    private List<Order> orders;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Rate> rates;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerValue() {
        return customerValue;
    }

    public void setCustomerValue(String customerValue) {
        this.customerValue = customerValue;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//
//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }

    public User(String customerValue, Person person, List<Order> orders, List<Rate> rates) {
        this.customerValue = customerValue;
//        this.person = person;
//        this.orders = orders;
        this.rates = rates;
    }

    public User() {}
}
