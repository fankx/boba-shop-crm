package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cookEmployees")
public class CookEmployee extends Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "employee_id",insertable = false, updatable = false)
    private Integer employeeId;

//    @OneToOne
//    @JsonIgnore
//    private Employee employee;

    @OneToMany(mappedBy = "cookEmployee")
    @JsonIgnore
    private List<DrinkAssign2Cook> drinkAssign2Cooks;


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
//
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }

    public CookEmployee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public List<DrinkAssign2Cook> getDrinkAssign2Cooks() {
        return drinkAssign2Cooks;
    }

    public CookEmployee(Integer employeeId, Employee employee, List<DrinkAssign2Cook> drinkAssign2Cooks) {
        this.employeeId = employeeId;
//        this.employee = employee;
        this.drinkAssign2Cooks = drinkAssign2Cooks;
    }

    public CookEmployee() {}
}
