package com.example.springtemplate.models;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="employees")
//@Inheritance(strategy = InheritanceType.JOINED)
public class Employee extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
//    @Column(name = "managerEmployee_id",insertable = false, updatable = false)
//    private Integer managerEmployeeId;

//    @OneToOne
//    @JsonIgnore
//    private Person person;
//
//    @OneToOne(mappedBy = "employee")
//    @JsonIgnore
//    private DeliveryEmployee deliveryEmployee;

//    @OneToOne(mappedBy = "employee")
//    @JsonIgnore
//    private CookEmployee cookEmployee;

    // self-referencing
    @OneToMany(mappedBy = "manager")
    @JsonIgnore
    private List<Employee> employees;

    @ManyToOne
    @JsonIgnore
    private Employee manager;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

//    public Person getPerson() {
//        return person;
//    }
//
//    public void setPerson(Person person) {
//        this.person = person;
//    }
//
//    public DeliveryEmployee getDeliveryEmployee() {
//        return deliveryEmployee;
//    }
//
//    public void setDeliveryEmployee(DeliveryEmployee deliveryEmployee) {
//        this.deliveryEmployee = deliveryEmployee;
//    }

//    public CookEmployee getCookEmployee() {
//        return cookEmployee;
//    }
//
//    public void setCookEmployee(CookEmployee cookEmployee) {
//        this.cookEmployee = cookEmployee;
//    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Employee(Person person, DeliveryEmployee deliveryEmployee, CookEmployee cookEmployee, List<Employee> employees, Employee manager) {
//        this.person = person;
//        this.deliveryEmployee = deliveryEmployee;

//        this.cookEmployee = cookEmployee;
        this.employees = employees;
        this.manager = manager;
    }

    public Employee() {}
}
