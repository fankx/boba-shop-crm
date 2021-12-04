package com.example.springtemplate.repositories;

import com.example.springtemplate.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRestRepository
        extends CrudRepository<User, Integer> {
    @Query(value = "SELECT users.id, customer_value, date_of_birth, email, first_name, last_name, password, username \n" +
            "FROM users, people \n" +
            "WHERE users.id = people.id;",  nativeQuery = true)
    List<User> findAllUsers();
    @Query(value = "SELECT users.id, customer_value, date_of_birth, email, first_name, last_name, password, username \n" +
            "FROM users, people \n" +
            "WHERE users.id = people.id\n" +
            "AND users.id = :userId",
            nativeQuery = true)
    User findUserById(@Param("userId") Integer id);

//    "SELECT users.id, customer_value, date_of_birth, email, first_name, last_name, password, username \n" +
//            "FROM users, people \n" +
//            "WHERE users.id = people.id\n" +
//            "AND users.id =:userId"
}