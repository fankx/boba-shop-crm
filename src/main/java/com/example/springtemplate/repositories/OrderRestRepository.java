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


}
