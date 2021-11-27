package com.example.springtemplate.daos;

import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.UserRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserRestOrmDao {
    @Autowired
    UserRestRepository userRepository;

    @PostMapping("/api/users")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    @GetMapping("/api/users/{userId}") // map this method to HTTP GET request execute this method when URL matches /api/users/ID
    public User findUserById(
            @PathVariable("userId") Integer id) {// parse user ID from path variable userId
        return userRepository.findUserById(id);// retrieve single user by ID and return as instance of User
    }

    @PutMapping("/api/users/{userId}")
    public User updateUser(
            @PathVariable("userId") Integer id,
            @RequestBody User userUpdates) {
        User user = userRepository.findUserById(id);
        user.setFirstName(userUpdates.getFirstName());
        user.setLastName(userUpdates.getLastName());
        user.setUsername(userUpdates.getUsername());
        user.setPassword(userUpdates.getPassword());
        user.setEmail(userUpdates.getEmail());
        user.setDateOfBirth(userUpdates.getDateOfBirth());
        user.setCustomerValue(userUpdates.getCustomerValue());
        return userRepository.save(user);
    }

    @DeleteMapping("/api/users/{userId}") // map this method to HTTP DELETE request
    public void deleteUser(// execute this method is URL matches /api/users/ID
                           @PathVariable("userId") Integer id) {// parse user's ID from path variable
        userRepository.deleteById(id);// use repository to permanently remove the user by their ID
    }
}