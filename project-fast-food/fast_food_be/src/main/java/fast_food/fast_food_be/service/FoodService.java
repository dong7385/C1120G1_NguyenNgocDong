package fast_food.fast_food_be.service;

import fast_food.fast_food_be.entity.Food;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodService {
    List<Food>searchListFood(String keySearch);
    Page<Food> getListFood(Pageable pageable);
    List<Food>findAll();
    Food getFoodById(Long foodId);
}
