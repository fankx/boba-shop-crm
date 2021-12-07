package com.example.springtemplate.daos;

import com.example.springtemplate.models.CookEmployee;
import com.example.springtemplate.models.Drink;
import com.example.springtemplate.repositories.CookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CookRestOrmDao {
    @Autowired
    CookRepository cookRepository;

    @PostMapping("/api/cooks")
    public CookEmployee createCook(@RequestBody CookEmployee cook) {
        return cookRepository.save(cook);
    }

    @GetMapping("/api/cooks")
    public List<CookEmployee> findAllCooks() {
        return cookRepository.findAllCooks();
    }

    @GetMapping("/api/cooks/{cookId}") // map this method to HTTP GET request execute this method when URL matches /api/cooks/ID
    public CookEmployee findCookById(
            @PathVariable("cookId") Integer id) {// parse cook ID from path variable cookId
        return cookRepository.findCookById(id);// retrieve single cook by ID and return as instance of Cook
    }

    @GetMapping("/api/cooks/{cookId}/drinks")
    public List<Drink> findDrinksByCookId(
            @PathVariable("cookId") Integer id){
        return cookRepository.findDrinksByCookId(id);
    }

    @GetMapping("/api/drinks/{drinkId}/cooks")
    public List<CookEmployee> findCooksByDrinkId(
            @PathVariable("drinkId") Integer id
    ){
        return cookRepository.findCooksByDrinkId(id);
    }


    @PutMapping("/api/cooks/{cookId}")
    public CookEmployee updateCook(
            @PathVariable("cookId") Integer id,
            @RequestBody CookEmployee cookUpdates) {
        CookEmployee cook = cookRepository.findCookById(id);
        cook.setManager(cookUpdates.getManager());
        cook.setFirstName(cookUpdates.getFirstName());
        cook.setLastName(cookUpdates.getLastName());
        cook.setUsername(cookUpdates.getUsername());
        cook.setPassword(cookUpdates.getPassword());
        cook.setEmail(cookUpdates.getEmail());
        cook.setDateOfBirth(cookUpdates.getDateOfBirth());
        return cookRepository.save(cook);
    }

    @DeleteMapping("/api/cooks/{cookId}") // map this method to HTTP DELETE request
    public void deleteCook(// execute this method is URL matches /api/cooks/ID
                           @PathVariable("cookId") Integer id) {// parse cook's ID from path variable
        cookRepository.deleteById(id);// use repository to permanently remove the cook by their ID
    }
}