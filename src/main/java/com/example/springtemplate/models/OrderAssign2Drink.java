package com.example.springtemplate.models;//package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="order_assign_2_drink")
public class OrderAssign2Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    private Integer dishId;
//    private Integer orderId;

    @ManyToOne
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JsonIgnore
    private Drink drink;
}
