package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Drink;
import com.example.springtemplate.models.DrinkType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DrinkRestRepository extends CrudRepository<Drink, Integer> {
    @Query(value = "SELECT * FROM drinks", nativeQuery = true)
    List<Drink> findAllDrinks();
    @Query(value = "SELECT * FROM drinks WHERE drinks.id = :drinkId", nativeQuery = true)
    Drink findDrinkById(@Param("drinkId") Integer id);
}
