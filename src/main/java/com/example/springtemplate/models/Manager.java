package com.example.springtemplate.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer managerId;

    @OneToMany
    private Employee manage;

    @ManyToOne
    @JsonIgnore
    private Employee managedBy;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Employee getManage() {
        return manage;
    }

    public void setManage(Employee manage) {
        this.manage = manage;
    }

    public Employee getManagedBy() {
        return managedBy;
    }

    public void setManagedBy(Employee managedBy) {
        this.managedBy = managedBy;
    }
}
