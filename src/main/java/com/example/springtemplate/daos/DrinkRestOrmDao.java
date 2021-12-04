package com.example.springtemplate.daos;

import com.example.springtemplate.models.Drink;
import com.example.springtemplate.repositories.DrinkRestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DrinkRestOrmDao {
    @Autowired
    DrinkRestRepository drinkRestRepository;

    @PostMapping("/api/drinks")
    public Drink createDrink(@RequestBody Drink drink) {
        return drinkRestRepository.save(drink);
    }

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
