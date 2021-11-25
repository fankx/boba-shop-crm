package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="order_assign_2_delivery")
public class OrderAssign2Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_id",insertable = false, updatable = false)
    private Integer orderId;

    @ManyToOne
    @JsonIgnore
    private DeliveryEmployee deliveryEmployee;

    @ManyToOne
    @JsonIgnore
    private Order order;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public DeliveryEmployee getDeliveryEmployee() {
        return deliveryEmployee;
    }

    public void setDeliveryEmployee(DeliveryEmployee deliveryEmployee) {
        this.deliveryEmployee = deliveryEmployee;
    }

    public OrderAssign2Delivery(Integer orderId, Order order) {
        this.orderId = orderId;
        this.order = order;
    }

    public OrderAssign2Delivery() {
    }
}
