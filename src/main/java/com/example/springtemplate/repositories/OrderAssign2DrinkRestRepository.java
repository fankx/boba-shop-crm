package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Drink;
import com.example.springtemplate.models.OrderAssign2Drink;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Repository
public interface OrderAssign2DrinkRestRepository
        extends CrudRepository<OrderAssign2Drink, Integer> {

    @Query (value = "SELECT * FROM order_assign_2_drink " +
            "WHERE order_assign_2_drink.id = :order2drinkId " ,
            nativeQuery = true)
    void findByO2dId(@Param("order2drinkId") Integer id);


    @Query (value = "DELETE FROM order_assign_2_drink \n" +
            "WHERE order_assign_2_drink.id :order2drinkId " ,
            nativeQuery = true)
    void deleteByO2dId(@Param("order2drinkId") Integer id);


    @Query(value = "SELECT order_assign_2_drink.id, order_assign_2_drink.drink_id, order_assign_2_drink.order_id\n" +
            "FROM  order_assign_2_drink\n" +
            "WHERE order_assign_2_drink.order_id = :oid", nativeQuery = true)
    List<OrderAssign2Drink> findDrinksForOrder(@Param("oid") Integer orderId);


}
