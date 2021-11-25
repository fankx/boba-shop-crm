package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="deliveryEmployees")
public class DeliveryEmployee extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "employee_id",insertable = false, updatable = false)
    private Integer employeeId;

//    @OneToOne
//    @JsonIgnore
//    private Employee employee;


    @OneToMany(mappedBy = "deliveryEmployee")
    @JsonIgnore
    private List<OrderAssign2Delivery> orderAssign2Delivery;

//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public List<OrderAssign2Delivery> getOrderAssignment() {
        return orderAssign2Delivery;
    }

    public void setOrderAssignment(List<OrderAssign2Delivery> orderAssign2Delivery) {
        this.orderAssign2Delivery = orderAssign2Delivery;
    }

    public DeliveryEmployee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public DeliveryEmployee() {}
}
