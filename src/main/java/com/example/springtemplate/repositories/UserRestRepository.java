package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRestRepository
        extends CrudRepository<Order, Integer> {
    @Query(value = "SELECT * FROM users",
            nativeQuery = true)
    public List<Order> findAllUsers();
    @Query(value = "SELECT * FROM users WHERE id=:userId",
            nativeQuery = true)
    public Order findUserById(@Param("userId") Integer id);
}
