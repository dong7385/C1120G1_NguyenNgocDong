package fast_food.fast_food_be.service.impl.security;

import fast_food.fast_food_be.entity.Role;
import fast_food.fast_food_be.repository.security.RoleRepository;
import fast_food.fast_food_be.service.security.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void saveRole(Role role) {

    }
}
