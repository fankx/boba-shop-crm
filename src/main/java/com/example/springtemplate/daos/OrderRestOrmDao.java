package com.example.springtemplate.daos;

import com.example.springtemplate.models.User;
import com.example.springtemplate.models.Order;
import com.example.springtemplate.repositories.OrderRestRepository;
import com.example.springtemplate.repositories.UserRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderRestOrmDao {
    @Autowired
    OrderRestRepository orderRepository;
    @Autowired
    UserRestRepository userRestRepository;
    @PostMapping("/api/orders")
    public Order createOrder(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @PostMapping("/api/users/{userId}/orders")
    public Order createOrderForUser(
            @PathVariable("userId") Integer uid,
            @RequestBody Order order) {
        order = orderRepository.save(order);
        User user = userRestRepository.findById(uid).get();
        order.setUser(user);
        return orderRepository.save(order);
    }

    @GetMapping("/api/users/{uid}/orders")
    public List<Order> findOrdersForUser(
            @PathVariable("uid") Integer userId) {
        User user = userRestRepository.findById(userId).get();
        return user.getOrders();}


    @GetMapping("/api/orders")
    public List<Order> findAllOrders() {
        return orderRepository.findAllOrders();
    }

    @GetMapping("/api/orders/{orderId}") // map this method to HTTP GET request execute this method when URL matches /api/orders/ID
    public Order findOrderById(
            @PathVariable("orderId") Integer id) {// parse order ID from path variable orderId
        return orderRepository.findOrderById(id);// retrieve single order by ID and return as instance of Order
    }

    @GetMapping("/api/orders/{orderId}/user") // map this method to HTTP GET request execute this method when URL matches /api/orders/ID
    public User findUserByOrderId(
            @PathVariable("orderId") Integer id) {// parse order ID from path variable orderId
        return userRestRepository.findUserIdByOrderId(id);// retrieve single order by ID and return as instance of Order
    }

    @PutMapping("/api/orders/{orderId}")
    public Order updateOrder(
            @PathVariable("orderId") Integer id,
            @RequestBody Order orderUpdates) {
        Order order = orderRepository.findOrderById(id);
        order.setAmount(orderUpdates.getAmount());
        order.setDiscount(orderUpdates.getDiscount());
        order.setTip(orderUpdates.getTip());
        //order.setUser(orderUpdates.getUser());

        return orderRepository.save(order);
    }

    @DeleteMapping("/api/orders/{orderId}") // map this method to HTTP DELETE request
    public void deleteOrder(// execute this method is URL matches /api/orders/ID
                           @PathVariable("orderId") Integer id) {// parse order's ID from path variable
        orderRepository.deleteById(id);// use repository to permanently remove the order by their ID
    }
}