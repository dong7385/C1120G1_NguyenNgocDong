package fast_food.fast_food_be.controller;


import fast_food.fast_food_be.entity.Food;
import fast_food.fast_food_be.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FoodController {

    @Autowired
    FoodService foodService;

    @GetMapping("home/searchKey")
    public ResponseEntity<List<Food>> searchFood(@RequestParam(defaultValue = "keySearch") String keySearch) {
        List<Food> listFood = foodService.searchListFood(keySearch);
        if (listFood.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listFood, HttpStatus.OK);
    }

    @GetMapping("home/list")
    public ResponseEntity<Page<Food>> findAllFood(@PageableDefault(value = 12) Pageable pageable) {
        Page<Food> listFood = foodService.getListFood(pageable);
        if (listFood.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listFood, HttpStatus.OK);
    }


    @GetMapping("/home/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable("id") Long foodId) {
        Food food = foodService.getFoodById(foodId);
        if (food != null) {
            return new ResponseEntity<>(food, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
