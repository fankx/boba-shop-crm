package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="users")
//@Inheritance(strategy = InheritanceType.JOINED)
public class User extends Person{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String customerValue;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Order> orders;

    @OneToMany(mappedBy = "ratedBy")
    @JsonIgnore
    private List<Rating> ratings;

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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Rating> getRates() {
        return ratings;
    }

    public void setRates(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public User(String firstName, String lastName, String username, String password, String email, Date dateOfBirth,String customerValue, List<Order> orders, List<Rating> ratings) {
        super( firstName,  lastName,  username,  password,  email,  dateOfBirth);
        setCustomerValue("0");
//        this.person = person;
        this.orders = orders;
        this.ratings = ratings;
    }

    public User() {}
}
