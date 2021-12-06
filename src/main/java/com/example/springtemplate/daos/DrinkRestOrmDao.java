package com.example.springtemplate.daos;

import com.example.springtemplate.models.Drink;
import com.example.springtemplate.models.Order;
import com.example.springtemplate.models.OrderAssign2Drink;
import com.example.springtemplate.models.User;
import com.example.springtemplate.repositories.DrinkRestRepository;
import com.example.springtemplate.repositories.OrderAssign2DrinkRestRepository;
import com.example.springtemplate.repositories.OrderRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DrinkRestOrmDao {
    @Autowired
    DrinkRestRepository drinkRestRepository;

    @Autowired
    OrderRestRepository orderRestRepository;

    @Autowired
    OrderAssign2DrinkRestRepository orderAssign2DrinkRestRepository;

    @PostMapping("/api/drinks")
    public Drink createDrink(@RequestBody Drink drink) {
        return drinkRestRepository.save(drink);
    }

//    @PostMapping("/api/orders/{orderId}/drinks")
//    public OrderAssign2Drink createDrinkForOrder(
//            @PathVariable("orderId") Integer oid,
//            @RequestBody OrderAssign2Drink orderAssign2Drink) {
//
//        orderAssign2Drink = orderAssign2DrinkRestRepository.save(orderAssign2Drink);
//        Order order = orderRestRepository.findById(oid).get();
//        orderAssign2Drink.setOrder(order);
//        return orderAssign2DrinkRestRepository.save(orderAssign2Drink);
//    }

//    @GetMapping("/api/orders/{orderId}/drinks")
//    public List<Drink> findDrinksForOrder(
//            @PathVariable("orderId") Integer oid) {
//        Order order = orderRestRepository.findOrderById(oid);
//        List<Drink> drinks = new ArrayList<>();
//        for (OrderAssign2Drink orderAssign2Drink : order.getOrderAssign2Drinks()) {
//            drinks.add(orderAssign2Drink.getDrink());
//        }
//        return drinks;}

//    @PutMapping("/api/orders/{orderId}/drinks")
//    public Order updateDrinksForOrder(
//            @PathVariable("orderId") Integer oid
//    @RequestBody Order orderUpdates) {
//        Order order = orderRestRepository.findOrderById(oid);
//        OrderAssign2Drink orderAssign2Drinks
//        orderUpdates.setOrderAssign2Drinks(orderAssign2Drinks);
//        return orderRestRepository.save(order);}



    @GetMapping("/api/drinks")
    public List<Drink> findAllDrinks() {
        return (List<Drink>)drinkRestRepository.findAll();
    }

    @GetMapping("/api/drinks/{drinkId}")
    public Drink findDrinkById(
            @PathVariable("drinkId") Integer id) {
        return drinkRestRepository.findById(id).get();
    }

    @PutMapping("/api/drinks/{drinkId}")
    public Drink updateDrink(
            @PathVariable("drinkId") Integer id,
            @RequestBody Drink drinkUpdates) {
        Drink drink = drinkRestRepository.findDrinkById(id);
        drink.setName(drinkUpdates.getName());
        drink.setPrice(drinkUpdates.getPrice());
        return drinkRestRepository.save(drink);
    }

    @DeleteMapping("api/drinks/{drinkId}")
    public void deleteDrink(
            @PathVariable("drinkId") Integer id) {
                drinkRestRepository.deleteById(id);
    }
}
