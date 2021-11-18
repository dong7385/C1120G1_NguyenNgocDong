package fast_food.fast_food_be.service.impl;

import fast_food.fast_food_be.dto.ListCartDto;
import fast_food.fast_food_be.entity.Food;
import fast_food.fast_food_be.repository.FoodRepository;
import fast_food.fast_food_be.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodRepository foodRepository;


    @Override
    public List<Food> searchListFood(String keySearch) {
        return foodRepository.searchListFood(keySearch);
    }

    @Override
    public Page<Food> getListFood(Pageable pageable) {
        return foodRepository.getListFood(pageable);
    }

    @Override
    public List<Food> findAll() {
        return foodRepository.findAll();
    }

    @Override
    public Food getFoodById(Long foodId) {
        return foodRepository.getFoodById(foodId);
    }

    @Override
    public Food saveOrder(ListCartDto listCartDto, String username) {
        return null;
    }
}
