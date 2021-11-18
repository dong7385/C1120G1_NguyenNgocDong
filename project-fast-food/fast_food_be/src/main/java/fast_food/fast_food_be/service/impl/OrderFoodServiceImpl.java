package fast_food.fast_food_be.service.impl;

import fast_food.fast_food_be.dto.CartDto;
import fast_food.fast_food_be.entity.OrderFood;
import fast_food.fast_food_be.repository.OrderFoodRepository;
import fast_food.fast_food_be.service.OrderFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderFoodServiceImpl implements OrderFoodService {
    @Autowired
    OrderFoodRepository orderFoodRepository;

    @Override
    public void saveOrderFoodDto(CartDto cartDto) {
      orderFoodRepository.saveOrderFoodDto(cartDto.getFoodId(),cartDto.getQuantity(),cartDto.getOrdersId());
    }

    @Override
    public List<OrderFood> getInfoOrderFood(String username) {
        return orderFoodRepository.getInfoOrderFood(username);
    }

}
