package com.example.springtemplate.repositories;

import com.example.springtemplate.models.OrderAssign2Drink;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderAssign2DrinkRestRepository
        extends CrudRepository<OrderAssign2Drink, Integer> {


    @Query (value = "DELETE FROM order_assign_2_drink " +
            "WHERE order_assign_2_drink.id = :order2drinkId " ,
            nativeQuery = true)
    void deleteByOrderIdAndDrinkId(@Param("order2drinkId") Integer id);
}
