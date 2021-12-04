package com.example.springtemplate.repositories;

import com.example.springtemplate.models.OrderAssign2Drink;
import org.springframework.data.repository.CrudRepository;

public interface OrderAssign2DrinkRestRepository
        extends CrudRepository<OrderAssign2Drink, Integer> {
}
