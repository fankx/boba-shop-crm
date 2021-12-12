package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRestRepository
        extends CrudRepository<Order, Integer> {
    @Query(value = "SELECT orders.id, orders.amount, orders.tip, orders.discount, orders.user_id\n" +
            "FROM orders",  nativeQuery = true)
    List<Order> findAllOrders();
    @Query(value = "SELECT orders.id,orders.amount, orders.tip, orders.discount, orders.user_id \n" +
            "FROM orders \n" +
            "WHERE  orders.id = :orderId",
            nativeQuery = true)
    Order findOrderById(@Param("orderId") Integer id);

    @Query(value = "SELECT DISTINCT orders.id,orders.amount,orders.tip,orders.discount,orders.user_id \n" +
            "FROM  order_assign_2_drink, orders\n" +
            "WHERE order_assign_2_drink.order_id = orders.id AND order_assign_2_drink.drink_id = :drinkId",
            nativeQuery = true)
    List<Order> findOrdersByDrinkId(@Param("drinkId") Integer drinkId);

}
