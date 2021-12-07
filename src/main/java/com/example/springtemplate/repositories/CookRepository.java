package com.example.springtemplate.repositories;

import com.example.springtemplate.models.CookEmployee;
import com.example.springtemplate.models.Drink;
import com.example.springtemplate.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CookRepository
        extends CrudRepository<CookEmployee, Integer> {
    //TODO why manager.id couldn't show, is it because it is an object?

    @Query(value = "SELECT cook_employees.id, employees.manager_id, date_of_birth, email, first_name, last_name, password, username\n" +
            "FROM cook_employees,  people,employees\n" +
            "WHERE cook_employees.id = people.id\n" +
            "AND cook_employees.id = employees.id",  nativeQuery = true)
    List<CookEmployee> findAllCooks();

    @Query(value = "SELECT cook_employees.id, employees.manager_id, date_of_birth, email, first_name, last_name, password, username\n" +
            "FROM cook_employees,  people,employees\n" +
            "WHERE cook_employees.id = people.id\n" +
            "AND cook_employees.id = employees.id\n" +
            "AND cook_employees.id= :cookId",
            nativeQuery = true)
    CookEmployee findCookById(@Param("cookId") Integer id);

    @Query(value = "SELECT cook_employees.id, employees.manager_id,date_of_birth, email, first_name, last_name, password, username\n" +
            "FROM cook_employees, drink_assign_2_cook, employees, people\n" +
            "WHERE drink_assign_2_cook.cook_employee_id = cook_employees.id \n" +
            "AND cook_employees.id = employees.id\n" +
            "AND employees.id = people.id\n" +
            "AND drink_assign_2_cook.drink_id= :drinkId",
            nativeQuery = true)
    List<CookEmployee> findCooksByDrinkId(@Param("drinkId") Integer id);

    @Query(value = "SELECT drinks.id, drinks.price, drinks.drink_type_drink_type\n" +
            "FROM cook_employees, drink_assign_2_cook,drinks\n" +
            "WHERE drink_assign_2_cook.cook_employee_id = cook_employees.id \n" +
            "AND drinks.id = drink_assign_2_cook.drink_id\n" +
            "AND cook_employees.id = :cookId ",
            nativeQuery = true)
    List<Drink> findDrinksByCookId(@Param("cookId") Integer id);
}