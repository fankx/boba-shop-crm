package com.example.springtemplate.daos;

import com.example.springtemplate.models.Drink;
import com.example.springtemplate.models.Order;
import com.example.springtemplate.models.OrderAssign2Drink;

import com.example.springtemplate.repositories.DrinkRestRepository;
import com.example.springtemplate.repositories.OrderAssign2DrinkRestRepository;
import com.example.springtemplate.repositories.OrderRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class OrderAssign2DrinkRestOrmDao {
    @Autowired
    OrderAssign2DrinkRestRepository orderAssign2DrinkRestRepository;
    @Autowired
    OrderRestRepository orderRestRepository;

    @Autowired
    DrinkRestRepository drinkRestRepository;

    //    @PostMapping("/api/orders/{orderId}/drinks")
//    public OrderAssign2Drink createDrinksForThisOrder(
//            @PathVariable("orderId") Integer orderId,
//            @RequestBody OrderAssign2Drink orderAssign2Drink) {
//        orderAssign2Drink = orderAssign2DrinkRestRepository.save(orderAssign2Drink);
//        Order order = orderRestRepository.findById(orderId).get();
//        orderAssign2Drink.setOrder(order);
//        return orderAssign2DrinkRestRepository.save(orderAssign2Drink);
//    }
// TODO 寫完
    @PostMapping("/api/o2d/{orderId}/drinks/{drinkId}")
    public OrderAssign2Drink createDrinksForCertainOrder(
            @PathVariable("orderId") Integer orderId,
            @PathVariable("drinkId") Integer drinkId,
            @RequestBody OrderAssign2Drink orderAssign2Drink) {
        //orderAssign2Drink = orderAssign2DrinkRestRepository.save(orderAssign2Drink);
        Order order = orderRestRepository.findById(orderId).get();
        Drink drink = drinkRestRepository.findById(drinkId).get();
        orderAssign2Drink.setOrder(order);
        orderAssign2Drink.setDrink(drink);
        return orderAssign2DrinkRestRepository.save(orderAssign2Drink);
    }

//    @PostMapping("/api/orders/{orderId}/drinks")
//    public OrderAssign2Drink createDrinkForThisOrder(
//            @PathVariable("orderId") Integer orderId,
//            @RequestBody OrderAssign2Drink orderAssign2Drink) {
//        orderAssign2Drink = orderAssign2DrinkRestRepository.save(orderAssign2Drink);
//        Order order = orderRestRepository.findById(orderId).get();
//        orderAssign2Drink.setOrder(order);
//        return orderAssign2DrinkRestRepository.save(orderAssign2Drink);
//    }

    @GetMapping("/api/orders/{orderId}/drinks")
    public List<OrderAssign2Drink> findDrinksForOrder(
            @PathVariable("orderId") Integer orderId) {
//        Order order = orderRestRepository.findOrderById(orderId);
//        List<Drink> drinks = new ArrayList<>();
//        for (OrderAssign2Drink orderAssign2Drink : order.getOrderAssign2Drinks()) {
//            drinks.add(orderAssign2Drink.getDrink());
//        }
//        return drinks;

        return orderAssign2DrinkRestRepository.findDrinksForOrder(orderId);
    }

//    @GetMapping("/api/orders/{oid}/drinks")
//    public List<Drink> findDrinksForOrder(
//            @PathVariable("oid") Integer orderId) {
////
//        return drinkRestRepository.findDrinksForOrder(orderId);
//    }

//    @GetMapping("/api/o2d/{oId}/drinks")
//    public List<Drink> findAllDrinksForThisOrderFromO2d(
//            @PathVariable("oId") Integer orderId) {
//        Order order = orderRestRepository.findOrderById(orderId);
//        List<Drink> drinks = new ArrayList<>();
//        for (OrderAssign2Drink orderAssign2Drink : order.getOrderAssign2Drinks()) {
//            drinks.add(orderAssign2Drink.getDrink());
//        }
//        return drinks;}

//    @GetMapping("/api/orders/{orderId}/drinks/{drinkId}")
//    public Drink findDrinkForThisOrder(
//            @PathVariable("orderId") Integer orderId,
//            @PathVariable("drinkId") Integer drinkId) {
//        Order order = orderRestRepository.findOrderById(orderId);
//        for (OrderAssign2Drink orderAssign2Drink : order.getOrderAssign2Drinks()) {
//            if (orderAssign2Drink.getDrink().getId() == drinkId) {
//                return orderAssign2Drink.getDrink();
//            }
//        }
//        return null;
//    }

    @GetMapping("api/o2d/{o2dId}/drinks")
    public void findByO2dId(
            @PathVariable("o2dId") Integer o2dId) {
        orderAssign2DrinkRestRepository.findByO2dId(o2dId);
    }

    @DeleteMapping("api/o2d/{o2dId}/drinks")
    public void deleteDrinkForThisOrder(
            @PathVariable("o2dId") Integer id) {

//                orderAssign2DrinkRestRepository.deleteByO2dId(id);
        orderAssign2DrinkRestRepository.deleteById(id);
    }
}