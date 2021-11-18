package fast_food.fast_food_be.service;

import fast_food.fast_food_be.dto.CartDto;
import fast_food.fast_food_be.entity.OrderFood;

import java.util.List;

public interface OrderFoodService {
    void saveOrderFoodDto(CartDto cartDto);

    List<OrderFood> getInfoOrderFood(String username);
}
